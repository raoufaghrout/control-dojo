package co.unruly.control_dojos.king_beards;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.Progress;
import co.unruly.control_dojos.king_beards.results.R_Beard;
import co.unruly.control_dojos.king_beards.results.R_Country;
import co.unruly.control_dojos.king_beards.results.R_King;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class ResultsTest {

    @Test
    public void King_Phillip_II_Of_Spain() {
        assumeTrue(Progress.hasStarted(Chapter.$06_WHAT_A_RESULT));

        R_Country spainIn1580 = new R_Country("Spain", new R_King("Phillip II", new R_Beard("brown")));

        assertThat(BeardColourGetter.getBeardColour(spainIn1580), is("brown"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain() {
        assumeTrue(
            Progress.hasStarted(Chapter.$06_WHAT_A_RESULT) &&
            !Progress.hasStarted(Chapter.$07_OK_EXPLAIN_YOURSELF));

        R_Country modernDaySpain = new R_Country("Spain", new R_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("n/a"));
    }

    @Test
    public void France() {
        assumeTrue(
            Progress.hasStarted(Chapter.$06_WHAT_A_RESULT) &&
            !Progress.hasStarted(Chapter.$07_OK_EXPLAIN_YOURSELF));

        R_Country modernDayFrance = new R_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("n/a"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain_With_Nice_Error_Messages() {
        assumeTrue(Progress.hasStarted(Chapter.$07_OK_EXPLAIN_YOURSELF));

        R_Country modernDaySpain = new R_Country("Spain", new R_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("Felipe VI has no beard"));
    }

    @Test
    public void France_With_Nice_Error_Messages() {
        assumeTrue(Progress.hasStarted(Chapter.$07_OK_EXPLAIN_YOURSELF));

        R_Country modernDayFrance = new R_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("France has no king"));
    }
}
