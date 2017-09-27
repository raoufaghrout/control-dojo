package co.unruly.control_dojos.fantasy_novels;

import co.unruly.control.result.Result;
import co.unruly.control_dojos.fantasy_novels.character.*;

import static co.unruly.control.ApplicableWrapper.apply;
import static co.unruly.control.ApplicableWrapper.startWith;
import static co.unruly.control.result.Transformers.onSuccess;

public class PulpFantasy {

    public static Result<Hero, Dead> saveTheWorld(Result<FarmBoy, Dead> protagonist) {
        return protagonist
                .then(onSuccess(PulpFantasy::callToAdventure))
                .then(onSuccess(PulpFantasy::refuseTheCall))
                .then(onSuccess(PulpFantasy::meetTheMentor))
                .then(onSuccess(PulpFantasy::crossTheThreshold))
                .then(onSuccess(PulpFantasy::faceTheOrdeal));
    }

    public static Hero saveTheWorld(FarmBoy protagonist) {
        return startWith(protagonist)
                .then(apply(PulpFantasy::callToAdventure))
                .then(apply(PulpFantasy::refuseTheCall))
                .then(apply(PulpFantasy::meetTheMentor))
                .then(apply(PulpFantasy::crossTheThreshold))
                .then(PulpFantasy::faceTheOrdeal);
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
