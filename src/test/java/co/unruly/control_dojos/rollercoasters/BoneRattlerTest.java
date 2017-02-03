package co.unruly.control_dojos.rollercoasters;

import co.unruly.control.Validation.Validator;
import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.rollercoasters.domain.Person;
import org.junit.Test;

import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.DOPEY;
import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.INIGO_MONTOYA;
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
        assumeTrue(Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE));

        assertThat(BONERATTLER_VALIDATOR.apply(DOPEY), is(failure("You must be 1m20 tall to ride")));
    }
}