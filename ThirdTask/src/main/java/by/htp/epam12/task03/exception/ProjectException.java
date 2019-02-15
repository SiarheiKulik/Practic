package by.htp.epam12.task03.exception;

public class ProjectException extends Exception {
    public ProjectException() {
    }

    public ProjectException(Throwable cause) {
        super(cause);
    }

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
