package co.unruly.control_dojos.rollercoasters;

import co.unruly.control.Validation.Validator;
import co.unruly.control.Validation.Validators;
import co.unruly.control_dojos.rollercoasters.domain.Group;
import co.unruly.control_dojos.rollercoasters.domain.Person;

public class RollercoasterValidators {

    public static Validator<Person, String> forBonerattler() {
        return Validators.rejectIf(person -> true /* condition goes here */, "error message goes here");
    }

    public static Validator<Person, String> forMondoLooper() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static Validator<Group, String> forSplishySplashyCanyon() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
