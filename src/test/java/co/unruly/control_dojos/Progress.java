package co.unruly.control_dojos;

import static org.junit.Assume.assumeTrue;

public class Progress {

    private final static Chapter CURRENT_CHAPTER = Chapter.$20_STARTING_AT_THE_VERY_BEGINNING;

    public static boolean hasStarted(Chapter chapter) {
        return chapter.number <= CURRENT_CHAPTER.number;
    }

    public static void between(Chapter first, Chapter second) {
        assumeTrue(hasStarted(first) && !hasStarted(second));
    }
}
