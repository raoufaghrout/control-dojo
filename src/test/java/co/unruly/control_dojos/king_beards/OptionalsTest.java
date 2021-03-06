package co.unruly.control_dojos.king_beards;

import co.unruly.control_dojos.Chapter;
import co.unruly.control_dojos.king_beards.optionals.O_Beard;
import co.unruly.control_dojos.king_beards.optionals.O_Country;
import co.unruly.control_dojos.king_beards.optionals.O_King;
import org.junit.Test;

import static co.unruly.control_dojos.Chapter.$04_BUT_WHYYYYY;
import static co.unruly.control_dojos.Chapter.$03_CALL_ME_MAYBE;
import static co.unruly.control_dojos.Chapter.$05_THE_DEVILS_IN_THE_DETAILS;
import static co.unruly.control_dojos.Progress.between;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assume.assumeTrue;

public class OptionalsTest {

    @Test
    public void King_Phillip_II_Of_Spain() {
        between($03_CALL_ME_MAYBE, Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        O_Country spainIn1580 = new O_Country("Spain", new O_King("Phillip II", new O_Beard("brown")));

        assertThat(BeardColourGetter.getBeardColour(spainIn1580), is("brown"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain() {
        between($03_CALL_ME_MAYBE, $04_BUT_WHYYYYY);

        O_Country modernDaySpain = new O_Country("Spain", new O_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("n/a"));
    }

    @Test
    public void France() {
        between($03_CALL_ME_MAYBE, $04_BUT_WHYYYYY);

        O_Country modernDayFrance = new O_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("n/a"));
    }

    @Test
    public void King_Felipe_VI_Of_Spain_With_Nice_Error_Messages() {
        between($05_THE_DEVILS_IN_THE_DETAILS, Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        O_Country modernDaySpain = new O_Country("Spain", new O_King("Felipe VI", null));

        assertThat(BeardColourGetter.getBeardColour(modernDaySpain), is("Felipe VI has no beard"));
    }

    @Test
    public void France_With_Nice_Error_Messages() {
        between($05_THE_DEVILS_IN_THE_DETAILS, Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE);

        O_Country modernDayFrance = new O_Country("France", null);

        assertThat(BeardColourGetter.getBeardColour(modernDayFrance), is("France has no king"));
    }
}
