package logic;

import exceptions.InvalidInputException;
import exceptions.MatrixOutOfBoundException;
import logic.factory.AbstractFactory;
import logic.factory.FactoryProducer;
import logic.interfaces.RoverDirections;
import model.Rover;
import model.enums.Direction;
import validator.Validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RoverInputSettings {

    public static void setMatrixDimensions(Scanner scanner) {
        System.out.println("enter the dimensions of the matrix (x y): ");

        String matrixDimensions = scanner.nextLine();

        if (!Pattern.matches("^\\d \\d$", matrixDimensions)) {
            throw new InvalidInputException();
        }

        String[] dimensions = matrixDimensions.split(" ");
        Rover.createInstance();
        Rover.getInstance().setMaxX(Integer.parseInt(dimensions[0]));
        Rover.getInstance().setMaxY(Integer.parseInt(dimensions[1]));
    }

    public static void setMatrixCoordinates(Scanner scanner) {
        System.out.println("enter the rover's first coordinate : ");

        String matrixCoordinates = scanner.nextLine();
        if (!Pattern.matches("^\\d \\d .$", matrixCoordinates)) {
            throw new InvalidInputException();
        }

        String[] coordinates = matrixCoordinates.split(" ");

        if (Integer.parseInt(coordinates[0]) > Rover.getInstance().getMaxX()) {
            throw new MatrixOutOfBoundException();
        }

        if (Integer.parseInt(coordinates[1]) > Rover.getInstance().getMaxY()) {
            throw new MatrixOutOfBoundException();
        }

        Validator.enumControl(Direction.class, coordinates[2]);

        Rover.getInstance().setX(Integer.parseInt(coordinates[0]));
        Rover.getInstance().setY(Integer.parseInt(coordinates[1]));
        Rover.getInstance().setDirection(Direction.valueOf(coordinates[2]));
    }

    public static void setMatrixWay(Scanner scanner) {
        System.out.println("enter the rover's way : ");
        String matrixWay = scanner.nextLine().trim().toUpperCase().replaceAll("\\s","");
        char[] ways = matrixWay.toCharArray();
        AbstractFactory roverFactory = FactoryProducer.getFactory("rover");
        for (char way : ways) {
            // it can be L,R,M
            String directionOfWay = String.valueOf(way);
            if (directionOfWay.equals("M")) {
                RoverDirections roverDirections = roverFactory.getDirection(Rover.getInstance().getDirection().getValue());
                roverDirections.moveForward();
            } else {
                Direction.turn(directionOfWay);
            }

        }
    }
}
