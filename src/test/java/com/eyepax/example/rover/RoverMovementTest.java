package com.eyepax.example.rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.exception.InvalidPositionException;
import com.eyepax.example.model.Plateau;
import com.eyepax.example.model.Rover;
import com.eyepax.example.model.direction.EastDirection;
import com.eyepax.example.model.direction.NorthDirection;
import com.eyepax.example.model.direction.SouthDirection;
import com.eyepax.example.model.direction.WestDirection;

public class RoverMovementTest {

    protected Plateau plateau;

    @Before
    public void setUp() throws Exception {
        plateau = Plateau.intializePlateau("5 5");
    }
    
    @Test(expected = InvalidCommandException.class)
    public void whenMoveCommandInvalid_invalidCharacters_thenException() {
        Rover rover = Rover.deployRover(plateau, "5 5 E");
        rover.processMovements("LRMMMRMLRMLQ");
    }
    
    @Test(expected = InvalidCommandException.class)
    public void whenMoveCommandInvalid_unneccessarySpaces_thenException() {
        Rover rover = Rover.deployRover(plateau, "5 5 E");
        rover.processMovements("LRMM MRML RML");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void whenMovePositionInvalid_caseOne_thenException() {
        Rover rover = Rover.deployRover(plateau, "5 5 E");
        rover.processMovements("MMM");
    }

    @Test(expected = InvalidPositionException.class)
    public void whenMovePositionInvalid_caseTwo_thenException() {
        Rover rover = Rover.deployRover(plateau, "3 2 S");
        rover.processMovements("MMM");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void whenMovePositionInvalid_caseThree_thenException() {
        Rover rover = Rover.deployRover(plateau, "1 5 N");
        rover.processMovements("MMM");
    }
    
    @Test
    public void whenMovement_turnLeftFromNorth_thenDirectionWest() {
        Rover rover = Rover.deployRover(plateau, "1 4 N");
        rover.processMovements("L");
        assertTrue(rover.getFacingDirection() instanceof WestDirection);
    }
    
    @Test
    public void whenMovement_turnLeftFromEast_thenDirectionNorth() {
        Rover rover = Rover.deployRover(plateau, "1 4 E");
        rover.processMovements("L");
        assertTrue(rover.getFacingDirection() instanceof NorthDirection);
    }
    
    @Test
    public void whenMovement_turnLeftFromSouth_thenDirectionEast() {
        Rover rover = Rover.deployRover(plateau, "1 4 S");
        rover.processMovements("L");
        assertTrue(rover.getFacingDirection() instanceof EastDirection);
    }
    
    @Test
    public void whenMovement_turnLeftFromWest_thenDirectionSouth() {
        Rover rover = Rover.deployRover(plateau, "1 4 W");
        rover.processMovements("L");
        assertTrue(rover.getFacingDirection() instanceof SouthDirection);
    }
    
    @Test
    public void whenMovement_turnRightFromNorth_thenDirectionEast() {
        Rover rover = Rover.deployRover(plateau, "1 4 N");
        rover.processMovements("R");
        assertTrue(rover.getFacingDirection() instanceof EastDirection);
    }
    
    @Test
    public void whenMovement_turnRightFromEast_thenDirectionSouth() {
        Rover rover = Rover.deployRover(plateau, "1 4 E");
        rover.processMovements("R");
        assertTrue(rover.getFacingDirection() instanceof SouthDirection);
    }
    
    @Test
    public void whenMovement_turnRightFromSouth_thenDirectionWest() {
        Rover rover = Rover.deployRover(plateau, "1 4 S");
        rover.processMovements("R");
        assertTrue(rover.getFacingDirection() instanceof WestDirection);
    }
    
    @Test
    public void whenMovement_turnRightFromWest_thenDirectionNorth() {
        Rover rover = Rover.deployRover(plateau, "1 4 W");
        rover.processMovements("R");
        assertTrue(rover.getFacingDirection() instanceof NorthDirection);
    }
    
    @Test
    public void whenComplexMovement_caseOne_thenShowOrientation() {
        Rover rover = Rover.deployRover(plateau, "1 2 N");
        rover.processMovements("LMLMLMLMM");
        assertEquals("1 3 N", rover.getCoordinatesAndDirection());
    }
    
    @Test
    public void whenComplexMovement_caseTwo_thenShowOrientation() {
        Rover rover = Rover.deployRover(plateau, "3 3 E");
        rover.processMovements("MMRMMRMRRM");
        assertEquals("5 1 E", rover.getCoordinatesAndDirection());
    }
    
    @Test
    public void whenComplexMovement_caseThree_thenShowOrientation() {
        Rover rover = Rover.deployRover(plateau, "1 3 E");
        rover.processMovements("MMMLLMRRMMRMMM");
        assertEquals("5 0 S", rover.getCoordinatesAndDirection());
    }
    
}
