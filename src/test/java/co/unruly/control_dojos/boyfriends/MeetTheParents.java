package co.unruly.control_dojos.boyfriends;

import co.unruly.control.validation.FailedValidation;
import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static co.unruly.control.result.Resolvers.successes;
import static co.unruly.control.result.Transformers.onFailureDo;
import static co.unruly.control_dojos.Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE;
import static co.unruly.control_dojos.Chapter.$16_THE_HEROS_JOURNEY;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.boyfriends.Boyfriends.*;
import static co.unruly.control_dojos.boyfriends.Parents.DAD_VALIDATION;
import static co.unruly.control_dojos.boyfriends.Parents.MOM_VALIDATION;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class MeetTheParents {

    @Mock
    Consumer<String> boyfriendComplaintLogger;

    @After
    public void wereYouEvenListeningToMe() {
        verifyNoMoreInteractions(boyfriendComplaintLogger);
    }

    @Test
    public void mumDoesntUnderstandMeAtAll() {
        between($08_YOU_MUST_BE_THIS_TALL_TO_RIDE, $16_THE_HEROS_JOURNEY);

        assertThat(MOM_VALIDATION.apply(DEAN), is(failure("He doesn't even have a job!", "He rides a **motorbike**!!!")));

        assertThat(MOM_VALIDATION.apply(CHRISTOPHER), is(failure("He's a bit old for you...")));
    }

    @Test
    public void dadDoesntLikeAnyOfMyBoyfriends() {
        between($08_YOU_MUST_BE_THIS_TALL_TO_RIDE, $16_THE_HEROS_JOURNEY);

        List<Boyfriend> guysMyDadLikes = Stream.of(DEAN, GARY, CHRISTOPHER)
            .map(DAD_VALIDATION)
            .peek(onFailureDo(complain(boyfriendComplaintLogger)))
            .flatMap(successes())
            .collect(Collectors.toList());

        verify(boyfriendComplaintLogger).accept("Dean: You deserve someone who at least went to university");
        verify(boyfriendComplaintLogger).accept("Gary: You deserve someone who at least went to university");
        verify(boyfriendComplaintLogger).accept("Gary: Estate agents are the scum of the earth");
        verify(boyfriendComplaintLogger).accept("Christopher: Lawyers are the absolute worst");

        assertThat(guysMyDadLikes, is(empty()));
    }


    private static Consumer<FailedValidation<Boyfriend, String>> complain(Consumer<String> complainer) {
        return bf -> bf.errors.forEach(fault -> complainer.accept(String.format("%s: %s", bf.value.getName(), fault)));
    }
}
