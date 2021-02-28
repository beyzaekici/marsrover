package directions;

import exceptions.MatrixOutOfBoundException;
import logic.interfaces.RoverDirections;
import model.Rover;

public class WestDirections implements RoverDirections {

    public void moveForward() {
        Rover.getInstance().setX(Rover.getInstance().getX() - 1);
        if (Rover.getInstance().getX() < 0) {
            throw new MatrixOutOfBoundException();
        }
    }
}


