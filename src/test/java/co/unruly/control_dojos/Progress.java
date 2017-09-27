package co.unruly.control_dojos;

import static org.junit.Assume.assumeTrue;

public class Progress {

    private final static Chapter CURRENT_CHAPTER = Chapter.$19_PLODDING_AND_PREDICTABLE;

    public static boolean hasStarted(Chapter chapter) {
        return chapter.number <= CURRENT_CHAPTER.number;
    }

    public static void between(Chapter first, Chapter second) {
        assumeTrue(hasStarted(first) && !hasStarted(second));
    }
}
