package by.htp.epam12.task01.exception;

public class ProjectExeption extends Exception {
    public ProjectExeption() {
    }

    public ProjectExeption(String message) {
        super(message);
    }

    public ProjectExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectExeption(Throwable cause) {
        super(cause);
    }
}
