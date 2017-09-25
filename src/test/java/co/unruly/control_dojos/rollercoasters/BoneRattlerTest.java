package co.unruly.control_dojos.rollercoasters;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.rollercoasters.domain.Person;
import co.unruly.control_dojos.rollercoasters.domain.Toddler;
import org.junit.Test;

import static co.unruly.control_dojos.Chapter.*;
import static co.unruly.control_dojos.Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.success;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

public class BoneRattlerTest {

    @Test
    public void acceptsRidersOver1m20Tall() {
        between($08_YOU_MUST_BE_THIS_TALL_TO_RIDE, $16_THE_HEROS_JOURNEY);

        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Brad Pitt", 185)), is(success()));
    }

    @Test
    public void rejectsRidersUnder1m20Tall() {
        between($08_YOU_MUST_BE_THIS_TALL_TO_RIDE, $10_SAY_MY_NAME_GUESS_MY_HEIGHT
         );

        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Warwick Davis", 116)), is(failure("You must be 1m20 tall to ride")));
    }

    @Test
    public void rejectsRidersUnder1m20TallInAMorePersonalWay() {
        between($10_SAY_MY_NAME_GUESS_MY_HEIGHT, $16_THE_HEROS_JOURNEY);

        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Warwick Davis", 116)), is(failure("Warwick Davis, you must be 1m20 tall to ride")));
        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Verne Troyer", 99)), is(failure("Verne Troyer, you must be 1m20 tall to ride")));
        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Tom Cruise", 132)), is(success()));
    }

    @Test
    public void rejectRidersUnder1m20TallAndHandleTantrums() {
        between($15_TRY_IT_FOR_YOURSELF, $16_THE_HEROS_JOURNEY);

        assertThat(RollercoasterValidators.forBonerattler().apply(new Toddler("Bobby Tables", 72)), is(failure("No disruption will be tolerated in the park")));
        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Warwick Davis", 116)), is(failure("Warwick Davis, you must be 1m20 tall to ride")));
        assertThat(RollercoasterValidators.forBonerattler().apply(new Person("Jeff Goldblum", 196)), is(success()));
    }
}