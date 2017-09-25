package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.*;

import static co.unruly.control.result.Transformers.onSuccess;

public class HerosJourney {

    public static Result<Hero, Dead> SaveTheWorld(Result<FarmBoy, Dead> protagonist) {
        return protagonist
            .then(onSuccess(HerosJourney::callToAdventure))
            .then(onSuccess(HerosJourney::refuseOfTheCall))
            .then(onSuccess(HerosJourney::meetTheMentor))
            .then(onSuccess(HerosJourney::crossTheThreshold))
            .then(onSuccess(HerosJourney::ordeal));
    }

    private static Squire callToAdventure(FarmBoy chara) {
        return new Squire(chara.name);
    }

    private static Naysayer refuseOfTheCall(Squire chara) {
        return new Naysayer(chara.name);
    }

    private static Apprentice meetTheMentor(Naysayer chara) {
        return new Apprentice(chara.name);
    }

    private static Knight crossTheThreshold(Apprentice chara) {
        return new Knight(chara.name);
    }

    private static Hero ordeal(Knight chara) {
        return new Hero(chara.name);
    }
}
