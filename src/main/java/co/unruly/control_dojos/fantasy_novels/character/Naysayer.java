package co.unruly.control_dojos.fantasy_novels.character;

public class Naysayer implements Named {
    public final String name;

    public Naysayer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
