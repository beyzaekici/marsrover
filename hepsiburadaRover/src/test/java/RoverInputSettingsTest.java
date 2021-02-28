import exceptions.InvalidDirectionException;
import exceptions.InvalidInputException;
import exceptions.MatrixOutOfBoundException;
import logic.RoverInputSettings;
import model.Rover;
import model.enums.Direction;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static utils.Utils.createRover;

public class RoverInputSettingsTest {

    @Test
    public void testSetMatrixDimensions_shouldBe_success() {
        String input = "5 5";

        RoverInputSettings.setMatrixDimensions(createScanner(input));

        assertEquals(5, Rover.getInstance().getMaxX());
        assertEquals(5, Rover.getInstance().getMaxY());
    }

    @Test(expected = InvalidInputException.class)
    public void testSetMatrixDimensions_should_throw_InvalidInputException() {
        String input = " 5";
        RoverInputSettings.setMatrixDimensions(createScanner(input));

    }


    @Test
    public void testSetMatrixCoordinates() {
        String input = "1 2 N";
        createRover();
        RoverInputSettings.setMatrixCoordinates(createScanner(input));

        assertEquals(1, Rover.getInstance().getX());
        assertEquals(2, Rover.getInstance().getY());
        assertEquals(Direction.N.value, Rover.getInstance().getDirection().value);
    }

    @Test(expected = InvalidInputException.class)
    public void testSetMatrixCoordinates_should_throw_InvalidInputException() {
        String input = " 1 2 ";
        RoverInputSettings.setMatrixCoordinates(createScanner(input));
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixCoordinates_should_throw_MatrixOutOfBoundException_When_X_Up() {
        String input = "6 3 N";
        createRover();
        RoverInputSettings.setMatrixCoordinates(createScanner(input));
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixCoordinates_should_throw_MatrixOutOfBoundException_When_Y_Up() {
        String input = "3 6 N";
        createRover();
        RoverInputSettings.setMatrixCoordinates(createScanner(input));
    }

    @Test(expected = InvalidDirectionException.class)
    public void testSetMatrixCoordinates_should_throw_InvalidDirectionException() {
        String input = "3 3 T";
        createRover();
        RoverInputSettings.setMatrixCoordinates(createScanner(input));
    }

    @Test
    public void testSetMatrixWay() {
        String input = "LMLMLMLMM";
        createRover();
        Rover.getInstance().setX(1);
        Rover.getInstance().setY(2);
        Rover.getInstance().setDirection(Direction.N);
        RoverInputSettings.setMatrixWay(createScanner(input));
        assertEquals(1, Rover.getInstance().getX());
        assertEquals(3, Rover.getInstance().getY());
        assertEquals("N", Rover.getInstance().getDirection().value);
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixWay_throw_exception_when_direction_N() {
        String input = "MMMMMMMMMMM";
        createRover();
        Rover.getInstance().setX(1);
        Rover.getInstance().setY(2);
        Rover.getInstance().setDirection(Direction.N);
        RoverInputSettings.setMatrixWay(createScanner(input));
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixWay_throw_exception_when_direction_S() {
        String input = "MMMMMMMMMMM";
        createRover();
        Rover.getInstance().setX(1);
        Rover.getInstance().setY(2);
        Rover.getInstance().setDirection(Direction.S);
        RoverInputSettings.setMatrixWay(createScanner(input));
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixWay_throw_exception_when_direction_W() {
        String input = "MMMMMMMMMMM";
        createRover();
        Rover.getInstance().setX(1);
        Rover.getInstance().setY(2);
        Rover.getInstance().setDirection(Direction.W);
        RoverInputSettings.setMatrixWay(createScanner(input));
    }

    @Test(expected = MatrixOutOfBoundException.class)
    public void testSetMatrixWay_throw_exception_when_direction_E() {
        String input = "MMMMMMMMMMM";
        createRover();
        Rover.getInstance().setX(1);
        Rover.getInstance().setY(2);
        Rover.getInstance().setDirection(Direction.E);
        RoverInputSettings.setMatrixWay(createScanner(input));
    }

    public Scanner createScanner(String value) {
        InputStream in = new ByteArrayInputStream(value.getBytes());
        return new Scanner(in);
    }
}
