package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.*;

public class PulpFantasy {

    public static Result<Hero, Dead> saveTheWorld(Result<FarmBoy, Dead> protagonist) {
        return null;
    }

    private static Squire callToAdventure(FarmBoy chara) {
        return new Squire(chara.name);
    }

    private static Naysayer refuseTheCall(Squire chara) {
        return new Naysayer(chara.name);
    }

    private static Apprentice meetTheMentor(Naysayer chara) {
        return new Apprentice(chara.name);
    }

    private static Knight crossTheThreshold(Apprentice chara) {
        return new Knight(chara.name);
    }

    private static Hero faceTheOrdeal(Knight chara) {
        return new Hero(chara.name);
    }
}
