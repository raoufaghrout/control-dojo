package co.unruly.control_dojos;

public class Progress {

    private final static Chapter CURRENT_CHAPTER = Chapter.$00_INTRODUCTION;

    public static boolean hasStarted(Chapter chapter) {
        return chapter.number <= CURRENT_CHAPTER.number;
    }
}
