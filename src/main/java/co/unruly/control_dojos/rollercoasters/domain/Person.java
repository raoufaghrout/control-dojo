package co.unruly.control_dojos.rollercoasters.domain;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Person {

    private final String name;
    private final int height;
    private final Set<MedicalCondition> medicalConditions;

    public Person(String name, int height, MedicalCondition... medicalConditions) {
        this.name = name;
        this.height = height;
        this.medicalConditions = Stream.of(medicalConditions).collect(toSet());
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public Set<MedicalCondition> getMedicalConditions() {
        return medicalConditions;
    }
}
