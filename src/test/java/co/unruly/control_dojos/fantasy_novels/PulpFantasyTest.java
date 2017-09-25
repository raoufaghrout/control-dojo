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
import static co.unruly.control_dojos.Chapter.$16_THE_HEROS_JOURNEY;
import static co.unruly.control_dojos.Chapter.$18_END_OF_THE_TALE;
import static co.unruly.control_dojos.Progress.between;
import static co.unruly.control_dojos.fantasy_novels.PulpFantasy.SaveTheWorld;
import static org.junit.Assert.assertThat;

public class PulpFantasyTest {

    @Test
    public void namedCharacterBecomesHeroAndSavesTheWorld() {
        between($16_THE_HEROS_JOURNEY, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(success(new FarmBoy("Luke")));

        assertThat(hero, isSuccessOf(new Hero("Luke")));
    }

    @Test
    public void cantDoAnythingAboutTerryWhoDiedInThePrologue() {
        between($16_THE_HEROS_JOURNEY, $18_END_OF_THE_TALE);

        Result<Hero, Dead> hero = SaveTheWorld(failure(new Dead("Terry")));

        assertThat(hero, isFailureOf(new Dead("Terry")));
    }
}
