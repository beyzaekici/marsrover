package model;

import exceptions.IllegalWayException;
import model.enums.Direction;
import org.junit.Assert;
import org.junit.Test;

import static utils.Utils.createRover;

public class DirectionTest {

    @Test
    public void turn_shouldBe_success_when_firstDirection_E_forMovement_L() {
        createRover();
        Rover.getInstance().setDirection(Direction.E);
        String movement = "L";
        Direction.turn(movement);
        Assert.assertEquals(Direction.N.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_S_forMovement_L() {
        createRover();
        Rover.getInstance().setDirection(Direction.S);
        String movement = "L";
        Direction.turn(movement);
        Assert.assertEquals(Direction.E.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_N_forMovement_L() {
        createRover();
        Rover.getInstance().setDirection(Direction.N);
        String movement = "L";
        Direction.turn(movement);
        Assert.assertEquals(Direction.W.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_W_forMovement_L() {
        createRover();
        Rover.getInstance().setDirection(Direction.W);
        String movement = "L";
        Direction.turn(movement);
        Assert.assertEquals(Direction.S.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_W_forMovement_R() {
        createRover();
        Rover.getInstance().setDirection(Direction.W);
        String movement = "R";
        Direction.turn(movement);
        Assert.assertEquals(Direction.N.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_S_forMovement_R() {
        createRover();
        Rover.getInstance().setDirection(Direction.S);
        String movement = "R";
        Direction.turn(movement);
        Assert.assertEquals(Direction.W.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_E_forMovement_R() {
        createRover();
        Rover.getInstance().setDirection(Direction.E);
        String movement = "R";
        Direction.turn(movement);
        Assert.assertEquals(Direction.S.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test
    public void turn_shouldBe_success_when_firstDirection_N_forMovement_R() {
        createRover();
        Rover.getInstance().setDirection(Direction.N);
        String movement = "R";
        Direction.turn(movement);
        Assert.assertEquals(Direction.E.getValue(), Rover.getInstance().getDirection().getValue());

    }

    @Test(expected = IllegalWayException.class)
    public void turn_should_throw_exception_when_input_wrong() {
        createRover();
        Rover.getInstance().setDirection(Direction.N);
        String movement = "*";
        Direction.turn(movement);
    }
}
