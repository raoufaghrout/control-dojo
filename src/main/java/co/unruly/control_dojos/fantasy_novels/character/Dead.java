package co.unruly.control_dojos.fantasy_novels.character;

import java.util.Objects;

public class Dead implements Named{
    public final String name;

    public Dead(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dead dead = (Dead) o;
        return Objects.equals(name, dead.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
