package co.unruly.control_dojos.king_beards;

import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.king_beards.optionals.O_Beard;
import co.unruly.control_dojos.king_beards.optionals.O_Country;
import co.unruly.control_dojos.king_beards.optionals.O_King;
import org.junit.Ignore;
import org.junit.Test;

import static co.unruly.control_dojos.Chapter.$04_BUT_WHYYYYY;
import static co.unruly.control_dojos.Chapter.$03_CALL_ME_MAYBE;
import static co.unruly.control_dojos.Chapter.$05_THE_DEVILS_IN_THE_DETAILS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class OptionalsTest {

    @Test
    public void King_Phillip_II_Of_Spain() {
        assumeTrue(Progress.hasStarted($03_CALL_ME_MAYBE));

        O_Country spainIn1580 = new O_Country("Spain", new O_King("Phillip II", new O_Beard("brown")));

        assertThat(BeardColourGetter.getBeardColour(spainIn1580), is("brown"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain() {
        assumeTrue(
            Progress.hasStarted($03_CALL_ME_MAYBE) &&
            !Progress.hasStarted($04_BUT_WHYYYYY));

        O_Country modernDaySpain = new O_Country("Spain", new O_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("n/a"));
    }

    @Test
    public void France() {
        assumeTrue(
            Progress.hasStarted($03_CALL_ME_MAYBE) &&
            !Progress.hasStarted($04_BUT_WHYYYYY));

        O_Country modernDayFrance = new O_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("n/a"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain_With_Nice_Error_Messages() {
        assumeTrue(Progress.hasStarted($05_THE_DEVILS_IN_THE_DETAILS));

        O_Country modernDaySpain = new O_Country("Spain", new O_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("Felipe VI has no beard"));
    }

    @Test
    public void France_With_Nice_Error_Messages() {
        assumeTrue(Progress.hasStarted($05_THE_DEVILS_IN_THE_DETAILS));

        O_Country modernDayFrance = new O_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("France has no king"));
    }
}
