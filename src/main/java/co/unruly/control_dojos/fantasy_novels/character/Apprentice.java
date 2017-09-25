package co.unruly.control_dojos.fantasy_novels.character;

public class Apprentice implements Named {
    public final String name;

    public Apprentice(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
