package co.unruly.control_dojos.boyfriends;

import java.util.Optional;

public class Boyfriend {

    private final String name;
    private final int age;
    private final EducationLevel educationLevel;
    private final Optional<Job> job;
    private final Optional<Vehicle> vehicle;

    public Boyfriend(String name, int age, EducationLevel educationLevel, Optional<Job> job, Optional<Vehicle> vehicle) {
        this.name = name;
        this.age = age;
        this.educationLevel = educationLevel;
        this.job = job;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public Optional<Job> getJob() {
        return job;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public String toString() {
        return name;
    }
}
