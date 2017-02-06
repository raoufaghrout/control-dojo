package co.unruly.control_dojos.king_beards.nulls;

public class N_Country {

    private final String name;
    private final N_King king;

    public N_Country(String name, N_King king) {
        this.name = name;
        this.king = king;
    }

    public String getName() { return name; }

    public N_King getKing() {
        return king;
    }
}
