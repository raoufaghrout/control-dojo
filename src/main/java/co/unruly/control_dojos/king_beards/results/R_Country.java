package co.unruly.control_dojos.king_beards.results;

import co.unruly.control.Result.Result;

public class R_Country {

    private final String name;
    private final R_King king;

    public R_Country(String name, R_King king) {
        this.king = king;
        this.name = name;
    }

    public Result<R_King, String> getKing() {
        return king != null
                ? Result.success(king)
                : Result.failure("n/a");
    }
}
