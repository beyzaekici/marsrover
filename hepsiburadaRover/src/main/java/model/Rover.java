package model;

import model.enums.Direction;

public class Rover {

    private static int x;
    private static int y;
    private static int maxX;
    private static int maxY;
    private static Direction direction;
    private static Rover instance;

    private Rover() {
    }

    public static Rover getInstance() {
        return instance;
    }

    public static void createInstance() {
        instance = new Rover();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        Rover.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        Rover.y = y;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        Rover.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        Rover.maxY = maxY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        Rover.direction = direction;
    }
}
