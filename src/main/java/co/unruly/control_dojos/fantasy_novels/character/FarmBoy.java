package co.unruly.control_dojos.fantasy_novels.character;

public class FarmBoy implements Named {
    public final String name;

    public FarmBoy(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
