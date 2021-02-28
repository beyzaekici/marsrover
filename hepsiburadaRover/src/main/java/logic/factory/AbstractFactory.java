package logic.factory;

import logic.interfaces.RoverDirections;

public abstract class AbstractFactory {

    public abstract RoverDirections getDirection(String direction);
}
