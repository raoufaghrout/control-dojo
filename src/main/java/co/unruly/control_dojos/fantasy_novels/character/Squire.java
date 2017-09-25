package co.unruly.control_dojos.fantasy_novels.character;

public class Squire implements Named {
    public final String name;

    public Squire(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
