package model.enums;

import exceptions.IllegalWayException;
import model.Rover;

public enum Direction {
    N("N"), S("S"), E("E"), W("W");

    public final String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void turn(String movement) {
        if ("L".equals(movement)) {
            switch (Rover.getInstance().getDirection()) {
                case E:
                    Rover.getInstance().setDirection(N);
                    break;
                case N:
                    Rover.getInstance().setDirection(W);
                    break;
                case W:
                    Rover.getInstance().setDirection(S);
                    break;
                case S:
                    Rover.getInstance().setDirection(E);
                    break;
            }
        } else if ("R".equals(movement)) {
            switch (Rover.getInstance().getDirection()) {
                case E:
                    Rover.getInstance().setDirection(S);
                    break;
                case S:
                    Rover.getInstance().setDirection(W);
                    break;
                case W:
                    Rover.getInstance().setDirection(N);
                    break;
                case N:
                    Rover.getInstance().setDirection(E);
                    break;
            }
        } else {
            throw new IllegalWayException();
        }
    }
}
