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
        assumeTrue(Progress.hasStarted(Chapter.$13_A_BIT_OF_A_DAMP_SQUIB));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(JD, TURK)),
            is(failure("Minimum group size is 3"))
        );
    }

    @Test
    public void maximumGroupSizeIs6() {
        assumeTrue(
            Progress.hasStarted(Chapter.$13_A_BIT_OF_A_DAMP_SQUIB) &&
            !Progress.hasStarted(Chapter.$14_THE_BIGGEST_BADDEST_DAMPEST_RIDE_OF_ALL_TIME)
        );

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(HAPPY, SLEEPY, SNEEZY, GRUMPY, BASHFUL, DOPEY, DOC)),
            is(failure("Maximum group size is 6"))
        );
    }

    @Test
    public void acceptGroupsBetween3And6() {
        assumeTrue(Progress.hasStarted(Chapter.$13_A_BIT_OF_A_DAMP_SQUIB));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(CHANDLER, JOEY, ROSS, MONICA, RACHEL, PHOEBE)),
            is(success())
        );

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(VIZZINI, INIGO_MONTOYA, FEZZEK)),
            is(success())
        );
    }


    @Test
    public void rejectGroupForBothSizeAndHeight() {
        assumeTrue(Progress.hasStarted(Chapter.$14_THE_BIGGEST_BADDEST_DAMPEST_RIDE_OF_ALL_TIME));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(HAPPY, SLEEPY, SNEEZY, GRUMPY, BASHFUL, DOPEY, DOC)),
            is(failure(
                "Maximum group size is 6",
                "Sleepy must be 1m20 tall to ride",
                "Bashful must be 1m20 tall to ride",
                "Dopey must be 1m20 tall to ride"
            ))
        );
    }

    @Test
    public void rejectHydrophobesItsForTheirOwnGoodYknow() {
        assumeTrue(Progress.hasStarted(Chapter.$14_THE_BIGGEST_BADDEST_DAMPEST_RIDE_OF_ALL_TIME));

        assertThat(
            RollercoasterValidators.forSplishySplashyCanyon().apply(Group.of(OZ, ELPHABA, NESSA)),
            is(failure("Elphaba must not risk getting wet"))
        );
    }
}
