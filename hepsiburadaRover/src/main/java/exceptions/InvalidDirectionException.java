package exceptions;

public class InvalidDirectionException extends RuntimeException{

    public InvalidDirectionException() {
        super("Please enter 3.coordinate as one of the compass direction like (W,E,S,N)");
    }
}
