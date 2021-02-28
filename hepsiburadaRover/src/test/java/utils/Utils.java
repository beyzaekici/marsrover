package utils;

import model.Rover;

public class Utils {

    public static void createRover() {
        Rover.createInstance();
        Rover.getInstance().setMaxX(5);
        Rover.getInstance().setMaxY(5);
    }
}
