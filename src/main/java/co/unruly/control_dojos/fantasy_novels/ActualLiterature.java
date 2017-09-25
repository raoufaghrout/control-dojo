package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.*;

import java.util.function.Function;

import static co.unruly.control.result.Result.failure;
import static co.unruly.control.result.Result.success;
import static java.util.Arrays.asList;

public class ActualLiterature {

    public static Result<Hero, Dead> SaveTheWorld(Result<FarmBoy, Dead> protagonist) {
        return null;
    }

    private static Result<Squire, Dead> callToAdventure(FarmBoy chara) {
        return growsIfNamed(chara, Squire::new, "Bobo", "Marillsillion", "Sean Bean");
    }

    private static Naysayer refuseTheCall(Squire chara) {
        return new Naysayer(chara.name());
    }

    private static Apprentice meetTheMentor(Naysayer chara) {
        return new Apprentice(chara.name());
    }

    private static Result<Knight, Dead> crossTheThreshold(Apprentice chara) {
        return growsIfNamed(chara, Knight::new, "Bobo", "Sean Bean");
    }

    private static Result<Hero, Dead> faceTheOrdeal(Knight chara) {
        return growsIfNamed(chara, Hero::new, "Bobo");
    }

    private static <T> Result<T, Dead> growsIfNamed(Named n, Function<String, T> nextStage, String... names) {
        if(asList(names).contains(n.name())) {
            return success(nextStage.apply(n.name()));
        } else {
            return failure(new Dead(n.name()));
        }
    }
}
