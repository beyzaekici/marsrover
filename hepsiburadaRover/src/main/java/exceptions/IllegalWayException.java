package exceptions;

public class IllegalWayException extends IllegalArgumentException{

    public IllegalWayException() {
        super("Please enter L,M or R");
    }
}
