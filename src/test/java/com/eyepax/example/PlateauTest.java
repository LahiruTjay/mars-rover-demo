package com.eyepax.example;

import org.junit.Test;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.model.Plateau;

public class PlateauTest {

    @Test(expected = InvalidCommandException.class)
    public void whenWrongInput_thenRuntime() {
        Plateau.intializePlateau("");
    }

}
