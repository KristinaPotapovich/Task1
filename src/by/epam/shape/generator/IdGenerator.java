package by.epam.shape.generator;

public class IdGenerator {
    private static long id = 1;

    private IdGenerator() {
    }

    public static long generateId() {
        return id++;
    }
}
