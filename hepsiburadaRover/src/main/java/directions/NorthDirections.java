package directions;

import exceptions.MatrixOutOfBoundException;
import logic.interfaces.RoverDirections;
import model.Rover;

public class NorthDirections implements RoverDirections {

    public void moveForward() {
        Rover.getInstance().setY(Rover.getInstance().getY() + 1);
        if (Rover.getInstance().getY() > Rover.getInstance().getMaxY()) {
            throw new MatrixOutOfBoundException();
        }
    }
}
