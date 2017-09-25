package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.Dead;
import co.unruly.control_dojos.fantasy_novels.character.FarmBoy;
import co.unruly.control_dojos.fantasy_novels.character.Hero;
import org.junit.Test;

import static co.unruly.control.matchers.ResultMatchers.isFailureOf;
import static co.unruly.control.matchers.ResultMatchers.isSuccessOf;
import static co.unruly.control.result.Result.success;
import static co.unruly.control_dojos.Chapter.$17_UNREMITTINGLY_GRIM_AND_HBO;
import static co.unruly.control_dojos.Chapter.$22_EVEN_WORSE_STORYTELLING;
import static co.unruly.control_dojos.Chapter.$24_END_OF_THE_ROAD;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.fantasy_novels.GameOfThronesier.saveTheWorld;
import static org.junit.Assert.assertThat;

public class GameOfThronesierTest {

    @Test
    public void seanBeanDiesBecauseOfTypecastingIGuess() {
        between($22_EVEN_WORSE_STORYTELLING, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Sean Bean")));

        assertThat(hero, isFailureOf(new Dead("Sean Bean")));
    }

    @Test
    public void ronSleetIsTheBestAtEverythingAndSavesTheWorld() {
        between($22_EVEN_WORSE_STORYTELLING, $24_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Ron Sleet")));

        assertThat(hero, isSuccessOf(new Hero("Ron Sleet")));
    }
}
