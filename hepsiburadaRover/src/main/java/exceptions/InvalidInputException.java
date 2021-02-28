package exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super("please enter inputs with spaces");
    }
}
