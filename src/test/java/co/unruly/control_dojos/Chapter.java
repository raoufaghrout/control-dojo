package co.unruly.control_dojos;

public enum Chapter {

    // Before we get started...
    $00_INTRODUCTION(0),

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
    $09_COMPOSE_YOURSELF_DEAR(9),
    $10_SAY_MY_NAME_GUESS_MY_HEIGHT(10),
    $11_SAY_CHEESE(11),
    $12_FANGS_FOR_THE_MEMORIES(12),
    $13_A_BIT_OF_A_DAMP_SQUIB(13),
    $14_THE_BIGGEST_BADDEST_DAMPEST_RIDE_OF_ALL_TIME(14),
    $15_TRY_IT_FOR_YOURSELF(15),

    // More results
    $16_THE_HEROS_JOURNEY(16),
    $17_UNREMITTINGLY_GRIM_AND_HBO(17),
    $18_A_TALE_OF_TWO_TOWERS(18),
    $19_PLODDING_AND_PREDICTABLE(19),
    $20_STARTING_AT_THE_VERY_BEGINNING(20),
    $21_PUTTING_IT_ALL_TOGETHER(21),
    $22_EVEN_WORSE_STORYTELLING(22),
    $23_A_COMPLETE_CATALOGUE_OF_WOE(23),
    $24_END_OF_THE_ROAD(24);

    public final int number;

    Chapter(int number) {
        this.number = number;
    }
}
