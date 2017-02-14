package co.unruly.control_dojos.rollercoasters;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import org.junit.Test;

import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.*;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.success;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class MondoLooperTest {

    @Test
    public void acceptNormalSizedRiders() {
        assumeTrue(Progress.hasStarted(Chapter.$09_COMPOSE_YOURSELF_DEAR));

        assertThat(RollercoasterValidators.forMondoLooper().apply(ROSS), is(success()));
    }

    @Test
    public void rejectRidersUnder1m20Tall() {
        assumeTrue(Progress.hasStarted(Chapter.$09_COMPOSE_YOURSELF_DEAR));

        assertThat(
            RollercoasterValidators.forMondoLooper().apply(BASHFUL),
            is(failure("You must be 1m20 tall to ride"))
        );
    }

    @Test
    public void rejectRidersOver2m10Tall() {
        assumeTrue(Progress.hasStarted(Chapter.$09_COMPOSE_YOURSELF_DEAR));

        assertThat(
            RollercoasterValidators.forMondoLooper().apply(FEZZEK),
            is(failure("You must be under 2m10 tall to ride"))
        );
    }
}
