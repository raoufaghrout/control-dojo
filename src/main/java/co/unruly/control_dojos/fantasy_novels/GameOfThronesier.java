package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.*;

import java.util.function.Function;

import static co.unruly.control.result.Result.failure;
import static co.unruly.control.result.Result.success;
import static co.unruly.control.result.Transformers.attempt;
import static co.unruly.control.result.Transformers.onSuccess;
import static co.unruly.control.result.Transformers.recover;
import static java.util.Arrays.asList;

public class GameOfThronesier {

    public static Result<Hero, Dead> saveTheWorld(Result<FarmBoy, Dead> protagonist) {
        return null;
    }

    private static Result<Squire, Dead> callToAdventure(FarmBoy chara) {
        return growsIfNamed(chara, Squire::new, "Ron Sleet", "Tom Thumb", "Aquaman", "Draco Malfoy", "Sean Bean");
    }

    private static Result<Naysayer, Dead> refuseTheCall(Squire chara) {
        return growsIfNamed(chara, Naysayer::new, "Ron Sleet", "Tom Thumb", "Aquaman", "Draco Malfoy");
    }

    private static Result<Apprentice, Dead> meetTheMentor(Naysayer chara) {
        return growsIfNamed(chara, Apprentice::new, "Ron Sleet", "Tom Thumb", "Draco Malfoy");
    }

    private static Result<Knight, Dead> crossTheThreshold(Apprentice chara) {
        return growsIfNamed(chara, Knight::new, "Tom Thumb");
    }

    private static Result<Hero, Dead> faceTheOrdeal(Knight chara) {
        return failure(new Dead(chara.name()));
    }

    private static Result<Hero, Dead> deusExMachina(Dead chara) {
        if("Ron Sleet".equals(chara.name())) {
            return success(new Hero("Ron Sleet"));
        } else {
            return failure(chara);
        }
    }

    private static <T> Result<T, Dead> growsIfNamed(Named n, Function<String, T> nextStage, String... names) {
        if(asList(names).contains(n.name())) {
            return success(nextStage.apply(n.name()));
        } else {
            return failure(new Dead(n.name()));
        }
    }
}
