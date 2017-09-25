package co.unruly.control_dojos.king_beards;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.king_beards.nulls.N_Beard;
import co.unruly.control_dojos.king_beards.nulls.N_Country;
import co.unruly.control_dojos.king_beards.nulls.N_King;
import org.junit.Test;

import static co.unruly.control_dojos.Chapter.*;
import static co.unruly.control_dojos.Chapter.$02_THE_PROBLEM_WITH_BEARDS;
import static co.unruly.control_dojos.Progress.between;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class NullyTest {

    @Test
    public void King_Phillip_II_Of_Spain() {
        between($01_THE_KING_OF_SPAINS_BEARD, $08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        N_Country spainIn1580 = new N_Country("Spain", new N_King("Phillip II", new N_Beard("brown")));

        assertThat(BeardColourGetter.getBeardColour(spainIn1580), is("brown"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain() {
        between($02_THE_PROBLEM_WITH_BEARDS, $04_BUT_WHYYYYY);

        N_Country modernDaySpain = new N_Country("Spain", new N_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("n/a"));
    }

    @Test
    public void France() {
        between($02_THE_PROBLEM_WITH_BEARDS, $04_BUT_WHYYYYY);

        N_Country modernDayFrance = new N_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("n/a"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain_With_Nice_Error_Messages() {
        between($04_BUT_WHYYYYY, $08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        N_Country modernDaySpain = new N_Country("Spain", new N_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("Felipe VI has no beard"));
    }

    @Test
    public void France_With_Nice_Error_Messages() {
        between($04_BUT_WHYYYYY, $08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        N_Country modernDayFrance = new N_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("France has no king"));
    }
}
