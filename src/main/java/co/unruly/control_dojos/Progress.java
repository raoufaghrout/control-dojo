package co.unruly.control_dojos;

public class Progress {

    private final static Chapter CURRENT_CHAPTER = Chapter.$08_YOU_MUST_BE_THIS_TALL_TO_RIDE;

    public static boolean hasStarted(Chapter chapter) {
        return chapter.number <= CURRENT_CHAPTER.number;
    }
}
