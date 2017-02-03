package co.unruly.control_dojos;

public enum Chapter {

    // Results
    $01_THE_KING_OF_SPAINS_BEARD(1),
    $02_THE_PROBLEM_WITH_BEARDS(2),
    $03_CALL_ME_MAYBE(3),
    $04_BUT_WHYYYYY(4),
    $05_THE_DEVILS_IN_THE_DETAILS(5),
    $06_WHAT_A_RESULT(6),
    $07_OK_EXPLAIN_YOURSELF(7),

    // Validations
    $08_YOU_MUST_BE_THIS_TALL_TO_RIDE(8),
    $09_COMPOSE_YOURSELF_DEAR(9);

    public final int number;

    Chapter(int number) {
        this.number = number;
    }
}
