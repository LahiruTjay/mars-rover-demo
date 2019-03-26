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

public class RoverInitilizationTest {

    protected Plateau plateau;

    @Before
    public void setUp() throws Exception {
        plateau = Plateau.intializePlateau("5 5");
    }

    @Test(expected = InvalidCommandException.class)
    public void whenEmptyInputCommand_thenException() {
        Rover.deployRover(plateau, "");
    }
    
    @Test(expected = InvalidCommandException.class)
    public void whenInvalidInputCommand_thenException() {
        Rover.deployRover(plateau, "33N");
    }
    
    @Test(expected = InvalidPositionException.class)
    public void whenInvalidInputCoordinates_thenException() {
        Rover.deployRover(plateau, "6 6 N");
    }
    
    @Test
    public void whenInputDirectionSpecifyNorth_thenInitilizeRoverOnNorth() {
        Rover rover = Rover.deployRover(plateau, "4 4 N");
        assertEquals(4, rover.getCurrentPosition().getCoordX());
        assertEquals(4, rover.getCurrentPosition().getCoordY());
        assertTrue(rover.getFacingDirection() instanceof NorthDirection);
    }

    @Test
    public void whenInputDirectionSpecifySouth_thenInitilizeRoverOnSouth() {
        Rover rover = Rover.deployRover(plateau, "5 4 S");
        assertEquals(5, rover.getCurrentPosition().getCoordX());
        assertEquals(4, rover.getCurrentPosition().getCoordY());
        assertTrue(rover.getFacingDirection() instanceof SouthDirection);
    }
    
    @Test
    public void whenInputDirectionSpecifyEast_thenInitilizeRoverOnEast() {
        Rover rover = Rover.deployRover(plateau, "2 4 E");
        assertEquals(2, rover.getCurrentPosition().getCoordX());
        assertEquals(4, rover.getCurrentPosition().getCoordY());
        assertTrue(rover.getFacingDirection() instanceof EastDirection);
    }
    
    @Test
    public void whenInputDirectionSpecifyWest_thenInitilizeRoverOnWest() {
        Rover rover = Rover.deployRover(plateau, "1 4 S");
        assertEquals(1, rover.getCurrentPosition().getCoordX());
        assertEquals(4, rover.getCurrentPosition().getCoordY());
        assertTrue(rover.getFacingDirection() instanceof SouthDirection);
    }
    
}
