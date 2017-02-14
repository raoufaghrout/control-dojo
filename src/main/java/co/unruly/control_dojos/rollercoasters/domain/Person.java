package co.unruly.control_dojos.rollercoasters.domain;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Person {

    public final String name;
    public final int height;
    public final Set<MedicalCondition> medicalConditions;
    public final boolean hasTicket;

    public Person(String name, int height, MedicalCondition... medicalConditions) {
        this.name = name;
        this.height = height;
        this.medicalConditions = Stream.of(medicalConditions).collect(toSet());
        this.hasTicket = true;
    }
}
