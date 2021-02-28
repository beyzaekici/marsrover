package directions;

import exceptions.MatrixOutOfBoundException;
import logic.interfaces.RoverDirections;
import model.Rover;

public class SouthDirections implements RoverDirections {

    public void moveForward() {
        Rover.getInstance().setY(Rover.getInstance().getY() - 1);
        if (Rover.getInstance().getY() < 0) {
            throw new MatrixOutOfBoundException();
        }
    }
}
