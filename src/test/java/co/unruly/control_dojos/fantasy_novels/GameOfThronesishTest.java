package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.pair.Pair;
import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.Dead;
import co.unruly.control_dojos.fantasy_novels.character.FarmBoy;
import co.unruly.control_dojos.fantasy_novels.character.Hero;
import org.junit.Test;

import java.util.List;

import static co.unruly.control.matchers.ResultMatchers.isFailureOf;
import static co.unruly.control.matchers.ResultMatchers.isSuccessOf;
import static co.unruly.control.result.Result.failure;
import static co.unruly.control.result.Result.success;
import static co.unruly.control_dojos.Chapter.*;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.fantasy_novels.GameOfThronesish.saveTheWorld;
import static co.unruly.control_dojos.fantasy_novels.GameOfThronesish.springtimeIsComing;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class GameOfThronesishTest {

    @Test
    public void someoneWhoStartsOffDeadRemainsDead() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(failure(new Dead("The Nights King")));

        assertThat(hero, isFailureOf(new Dead("The Nights King")));
    }

    @Test
    public void randomCharactersDontStandAChance() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Donny")));

        assertThat(hero, isFailureOf(new Dead("Donny")));
    }

    @Test
    public void seanBeanDiesBecauseOfTypecastingIGuess() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Sean Bean")));

        assertThat(hero, isFailureOf(new Dead("Sean Bean")));
    }

    @Test
    public void aquamanDiesBecauseHeLivesInADesertAndDriesOut() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Aquaman")));

        assertThat(hero, isFailureOf(new Dead("Aquaman")));
    }

    @Test
    public void dracoMalfoyDiesBecauseUltimatelyItsAllWeReallyWanted() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Draco Malfoy")));

        assertThat(hero, isFailureOf(new Dead("Draco Malfoy")));
    }

    @Test
    public void tomThumbIsNotAsCleverAsHeThinksHeIs() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Tom Thumb")));

        assertThat(hero, isFailureOf(new Dead("Tom Thumb")));
    }

    @Test
    public void ronSleetIsTheBestAtEverythingAndSavesTheWorld() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Ron Sleet")));

        assertThat(hero, isSuccessOf(new Hero("Ron Sleet")));
    }

    @Test
    public void soYouSavedTheWorldOfTheLiving_GazeOnHowEmptyItIs() {
        between($23_A_COMPLETE_CATALOGUE_OF_WOE, $24_END_OF_THE_ROAD);

        Pair<List<Hero>, List<Dead>> everyone = springtimeIsComing("Donny", "Sean Bean", "Aquaman", "Draco Malfoy", "Tom Thumb", "Ron Sleet");

        assertThat(everyone.right, hasItems(
                new Dead("Donny"),
                new Dead("Sean Bean"),
                new Dead("Aquaman"),
                new Dead("Draco Malfoy"),
                new Dead("Tom Thumb")
        ));

        assertThat(everyone.left, hasItems(
                new Hero("Ron Sleet")
        ));
    }
}
