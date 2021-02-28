package logic.factory;

import directions.EastDirections;
import directions.NorthDirections;
import directions.SouthDirections;
import directions.WestDirections;
import logic.interfaces.RoverDirections;

public class RoverFactory extends AbstractFactory {

    @Override
    public RoverDirections getDirection(String direction) {
        if (direction.equalsIgnoreCase("E")) {
            return new EastDirections();
        } else if (direction.equalsIgnoreCase("W")) {
            return new WestDirections();
        } else if (direction.equalsIgnoreCase("S")) {
            return new SouthDirections();
        } else if (direction.equalsIgnoreCase("N")) {
            return new NorthDirections();
        }
        return null;
    }
}
