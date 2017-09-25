package co.unruly.control_dojos.fantasy_novels.character;

public class Knight implements Named {
    public final String name;

    public Knight(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
