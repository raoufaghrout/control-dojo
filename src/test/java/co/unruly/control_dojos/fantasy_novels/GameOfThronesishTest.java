package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.Dead;
import co.unruly.control_dojos.fantasy_novels.character.FarmBoy;
import co.unruly.control_dojos.fantasy_novels.character.Hero;
import org.junit.Test;

import static co.unruly.control.matchers.ResultMatchers.isFailureOf;
import static co.unruly.control.matchers.ResultMatchers.isSuccessOf;
import static co.unruly.control.result.Result.failure;
import static co.unruly.control.result.Result.success;
import static co.unruly.control_dojos.Chapter.$17_UNREMITTINGLY_GRIM_AND_HBO;
import static co.unruly.control_dojos.Chapter.$18_END_OF_THE_TALE;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.fantasy_novels.GameOfThronesish.SaveTheWorld;
import static org.junit.Assert.assertThat;

public class GameOfThronesishTest {

    @Test
    public void someoneWhoStartsOffDeadRemainsDead() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(failure(new Dead("The Nights King")));

        assertThat(hero, isFailureOf(new Dead("The Nights King")));
    }

    @Test
    public void randomCharactersDontStandAChance() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Donny")));

        assertThat(hero, isFailureOf(new Dead("Donny")));
    }

    @Test
    public void seanBeanDiesBecauseOfTypecastingIGuess() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Sean Bean")));

        assertThat(hero, isFailureOf(new Dead("Sean Bean")));
    }

    @Test
    public void aquamanDiesBecauseHeLivesInADesertAndDriesOut() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Aquaman")));

        assertThat(hero, isFailureOf(new Dead("Aquaman")));
    }

    @Test
    public void dracoMalfoyDiesBecauseUltimatelyItsAllWeReallyWanted() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Draco Malfoy")));

        assertThat(hero, isFailureOf(new Dead("Draco Malfoy")));
    }

    @Test
    public void tomThumbIsNotAsCleverAsHeThinksHeIs() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Tom Thumb")));

        assertThat(hero, isFailureOf(new Dead("Tom Thumb")));
    }

    @Test
    public void ronSleetIsTheBestAtEverythingAndSavesTheWorld() {
        between($17_UNREMITTINGLY_GRIM_AND_HBO, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Ron Sleet")));

        assertThat(hero, isSuccessOf(new Hero("Ron Sleet")));
    }
}
