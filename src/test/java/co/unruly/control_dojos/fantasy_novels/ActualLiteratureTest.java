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
import static co.unruly.control_dojos.Chapter.$18_A_TALE_OF_TWO_TOWERS;
import static co.unruly.control_dojos.Chapter.$20_STARTING_AT_THE_VERY_BEGINNING;
import static co.unruly.control_dojos.Chapter.$21_END_OF_THE_ROAD;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.fantasy_novels.ActualLiterature.saveTheWorld;
import static org.junit.Assert.assertThat;

public class ActualLiteratureTest {

    @Test
    public void someoneWhoStartsOffDeadRemainsDead() {
        between($18_A_TALE_OF_TWO_TOWERS, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(failure(new Dead("The Witch King of Hangman")));

        assertThat(hero, isFailureOf(new Dead("The Witch King of Hangman")));
    }

    @Test
    public void randomCharactersDontStandAChance() {
        between($18_A_TALE_OF_TWO_TOWERS, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Donny")));

        assertThat(hero, isFailureOf(new Dead("Donny")));
    }

    @Test
    public void seanBeanDiesBecauseOfTypecastingIGuess() {
        between($18_A_TALE_OF_TWO_TOWERS, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Sean Bean")));

        assertThat(hero, isFailureOf(new Dead("Sean Bean")));
    }

    @Test
    public void marillSillionDoesntMakeItThroughTheSpikyMountain() {
        between($18_A_TALE_OF_TWO_TOWERS, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Marillsillion")));

        assertThat(hero, isFailureOf(new Dead("Marillsillion")));
    }

    @Test
    public void boboAcquiresHisPrecious() {
        between($18_A_TALE_OF_TWO_TOWERS, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(success(new FarmBoy("Bobo")));

        assertThat(hero, isSuccessOf(new Hero("Bobo")));
    }

    @Test
    public void randomCharactersDontDieQuickly() {
        between($20_STARTING_AT_THE_VERY_BEGINNING, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(new FarmBoy("Donny"));

        assertThat(hero, isFailureOf(new Dead("Donny")));
    }

    @Test
    public void seanBeanDiesBecauseThatsWhatHisCvIsFullOf() {
        between($20_STARTING_AT_THE_VERY_BEGINNING, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(new FarmBoy("Sean Bean"));

        assertThat(hero, isFailureOf(new Dead("Sean Bean")));
    }

    @Test
    public void marillSillionDoesntMakeItThroughTheFireSwamp() {
        between($20_STARTING_AT_THE_VERY_BEGINNING, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(new FarmBoy("Marillsillion"));

        assertThat(hero, isFailureOf(new Dead("Marillsillion")));
    }

    @Test
    public void boboMakesItThereAndBackAgain() {
        between($20_STARTING_AT_THE_VERY_BEGINNING, $21_END_OF_THE_ROAD);

        Result<Hero, Dead> hero = saveTheWorld(new FarmBoy("Bobo"));

        assertThat(hero, isSuccessOf(new Hero("Bobo")));
    }
}
