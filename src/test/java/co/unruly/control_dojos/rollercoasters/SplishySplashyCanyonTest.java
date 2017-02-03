package co.unruly.control_dojos.rollercoasters;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.rollercoasters.domain.Group;
import org.junit.Test;

import static co.unruly.control_dojos.rollercoasters.test_support.FamousPeople.*;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.failure;
import static co.unruly.control_dojos.rollercoasters.test_support.ValidationMatchers.success;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class SplishySplashyCanyonTest {

    @Test
    public void minimumGroupSizeIs3() {
        assumeTrue(Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(JD, TURK)),
            is(failure("Minimum group size is 3"))
        );
    }

    @Test
    public void maximumGroupSizeIs6() {
        assumeTrue(Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(HAPPY, SLEEPY, SNEEZY, GRUMPY, BASHFUL, DOPEY, DOC)),
            is(failure("Maximum group size is 6"))
        );
    }

    @Test
    public void acceptGroupsBetween3And6() {
        assumeTrue(Progress.hasStarted(Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(CHANDLER, JOEY, ROSS, MONICA, RACHEL, PHOEBE)),
            is(success())
        );

        assertThat(
                RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(VIZZINI, INIGO_MONTOYA, FEZZEK)),
                is(success())
        );
    }
}
