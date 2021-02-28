package exceptions;

public class MatrixOutOfBoundException extends RuntimeException {

    public MatrixOutOfBoundException() {
        super("Index out of bound");
    }
}
