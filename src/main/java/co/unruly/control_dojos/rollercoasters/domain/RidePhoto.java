package co.unruly.control_dojos.rollercoasters.domain;

import java.util.Objects;

public class RidePhoto {

    private final Person subject;

    public RidePhoto(Person subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "RidePhoto{" +
            "subject=" + subject +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RidePhoto ridePhoto = (RidePhoto) o;
        return Objects.equals(subject, ridePhoto.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
