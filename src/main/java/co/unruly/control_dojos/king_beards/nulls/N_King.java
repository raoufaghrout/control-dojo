package co.unruly.control_dojos.king_beards.nulls;

public class N_King {

    private final String name;
    private final N_Beard beard;

    public N_King(String name, N_Beard beard) {
        this.name = name;
        this.beard = beard;
    }

    public String getName() { return name; }

    public N_Beard getBeard() {
        return beard;
    }
}
