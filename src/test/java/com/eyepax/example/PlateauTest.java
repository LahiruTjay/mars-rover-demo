package com.eyepax.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.model.Plateau;

public class PlateauTest {

    @Test(expected = InvalidCommandException.class)
    public void whenWrongInput_thenException() {
        Plateau.intializePlateau("");
    }

    @Test
    public void whenCorrectInput_thenInitializePlateau() {
        Plateau plateau = Plateau.intializePlateau("5 5");
        assertEquals(5, plateau.getUpperBoundX());
        assertEquals(5, plateau.getUpperBoundY());
    }
}
