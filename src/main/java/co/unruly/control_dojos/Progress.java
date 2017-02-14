package co.unruly.control_dojos;

public class Progress {

    private final static Chapter CURRENT_CHAPTER = Chapter.$12_FANGS_FOR_THE_MEMORIES;

    public static boolean hasStarted(Chapter chapter) {
        return chapter.number <= CURRENT_CHAPTER.number;
    }
}
