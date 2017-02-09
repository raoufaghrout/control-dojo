package co.unruly.control_dojos.boyfriends;

import co.unruly.control.Validation.Validator;

import java.util.Optional;

import static co.unruly.control.Validation.Validators.*;
import static co.unruly.control_dojos.boyfriends.Job.ESTATE_AGENT;
import static co.unruly.control_dojos.boyfriends.Job.LAWYER;
import static co.unruly.control_dojos.boyfriends.Vehicle.HARLEY_DAVIDSON;

public class Parents {

    public static Validator<Boyfriend, String> MOM_VALIDATION = compose(
        rejectIf(bf -> bf.getAge() > 32, "He's a bit old for you..."),

        on(Boyfriend::getJob,
            acceptIf(Optional::isPresent, "He doesn't even have a job!")
        ),

        on(Boyfriend::getVehicle,
            rejectIf(Optional.of(HARLEY_DAVIDSON)::equals, "He rides a **motorbike**!!!")
        )
    );

    public static Validator<Boyfriend, String> DAD_VALIDATION = compose(
        rejectIf(bf -> bf.getEducationLevel().compareTo(EducationLevel.GRADUATE) < 0, "You deserve someone who at least went to university"),

        on(Boyfriend::getJob,
            compose(
                rejectIf(Optional.of(ESTATE_AGENT)::equals, "Estate agents are the scum of the earth"),
                rejectIf(Optional.of(LAWYER)::equals, "Lawyers are the absolute worst")
            )
        )
    );
}
