package co.unruly.control_dojos.rollercoasters;

import co.unruly.control.Validation.Validator;
import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.rollercoasters.domain.Person;
import org.junit.Test;

import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.*;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.success;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

public class BoneRattlerTest {

    public static final Validator<Person, String> BONERATTLER_VALIDATOR = RollercoasterValidators.forBonerattler();

    @Test
    public void acceptsRidersOver1m20Tall() {
        assumeTrue(Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE));

        assertThat(BONERATTLER_VALIDATOR.apply(INIGO_MONTOYA), is(success()));
    }

    @Test
    public void rejectsRidersUnder1m20Tall() {
        assumeTrue(
            Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE) &&
            !Progress.hasStarted(Chapter.$10_SAY_MY_NAME_GUESS_MY_HEIGHT)
         );

        assertThat(BONERATTLER_VALIDATOR.apply(DOPEY), is(failure("You must be 1m20 tall to ride")));
    }

    @Test
    public void rejectsRidersUnder1m20TallInAMorePersonalWay() {
        assumeTrue(Progress.hasStarted(Chapter.$10_SAY_MY_NAME_GUESS_MY_HEIGHT));

        assertThat(BONERATTLER_VALIDATOR.apply(DOPEY), is(failure("Dopey, you must be 1m20 tall to ride")));
        assertThat(BONERATTLER_VALIDATOR.apply(BASHFUL), is(failure("Bashful, you must be 1m20 tall to ride")));
        assertThat(BONERATTLER_VALIDATOR.apply(DOC), is(success()));
    }
}