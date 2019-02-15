package by.htp.epam12.task01.generator;

public class IdGenerator {

    private static long counter = 1;

    public static long getTriangleId() {
        return counter++;
    }

}
