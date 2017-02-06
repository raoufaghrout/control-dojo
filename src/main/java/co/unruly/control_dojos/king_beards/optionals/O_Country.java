package co.unruly.control_dojos.king_beards.optionals;

import java.util.Optional;

public class O_Country {

    private final String name;
    private final O_King king;

    public O_Country(String name, O_King king) {
        this.name = name;
        this.king = king;
    }

    public String getName() { return name; }

    public Optional<O_King> getKing() {
        return Optional.ofNullable(king);
    }
}
