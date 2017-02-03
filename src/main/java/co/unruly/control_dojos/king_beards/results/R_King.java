package co.unruly.control_dojos.king_beards.results;

import co.unruly.control.Result.Result;

public class R_King {

    private final String name;
    private final R_Beard beard;

    public R_King(String name, R_Beard beard) {
        this.name = name;
        this.beard = beard;
    }

    public Result<R_Beard, String> getBeard() {
        return beard != null
                ? Result.success(beard)
                : Result.failure("n/a");
    }
}