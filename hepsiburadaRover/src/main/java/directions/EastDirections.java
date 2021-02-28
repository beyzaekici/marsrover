package directions;

import exceptions.MatrixOutOfBoundException;
import logic.interfaces.RoverDirections;
import model.Rover;

public class EastDirections implements RoverDirections {

    public void moveForward() {
        Rover.getInstance().setX(Rover.getInstance().getX() + 1);
        if (Rover.getInstance().getX() > Rover.getInstance().getMaxX()) {
            throw new MatrixOutOfBoundException();
        }
    }
}
