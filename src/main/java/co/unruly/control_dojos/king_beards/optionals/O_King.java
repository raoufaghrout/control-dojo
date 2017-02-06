package co.unruly.control_dojos.king_beards.optionals;

import java.util.Optional;

public class O_King {

    private final String name;
    private final O_Beard beard;

    public O_King(String name, O_Beard beard) {
        this.name = name;
        this.beard = beard;
    }

    public String getName() { return name; }

    public Optional<O_Beard> getBeard() {
        return Optional.ofNullable(beard);
    }
}
