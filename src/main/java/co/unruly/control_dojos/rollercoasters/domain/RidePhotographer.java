package co.unruly.control_dojos.rollercoasters.domain;

import co.unruly.control.Result.Result;

import java.util.List;

import static co.unruly.control.Result.Result.failure;
import static co.unruly.control.Result.Result.success;
import static java.util.Collections.singletonList;

public class RidePhotographer {

    public static RidePhoto takePhoto(Person person) {
        return new RidePhoto(person);
    }

    public static Result<RidePhoto, List<String>> tryTakePhoto(Person person) {
        if(person.medicalConditions.contains(MedicalCondition.APHOTOGRAPHIA)) {
            return failure(singletonList(person.name + " could not be photographed"));
        } else {
            return success(new RidePhoto(person));
        }
    }
}
