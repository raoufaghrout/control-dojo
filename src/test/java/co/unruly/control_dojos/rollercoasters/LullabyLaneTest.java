package co.unruly.control_dojos.rollercoasters;

import org.junit.Test;

import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.SLEEPY;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LullabyLaneTest {

    @Test
    public void shouldRejectRidersWhoAreTooSleepy() {
        assertThat(
            RollercoasterValidators.forLullabyLane().apply(SLEEPY),
            is(failure("It is dangerous to fall into too deep a sleep"))
        );
    }
}
