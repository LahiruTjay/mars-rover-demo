package com.eyepax.example;

import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.eyepax.example.exception.RoverCommandsUnavailable;
import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.exception.InvalidPositionException;
import com.eyepax.example.model.Plateau;
import com.eyepax.example.model.Rover;
import com.eyepax.example.util.InputUtil;

public class MarsRoverDemo {

    private static final Logger logger = Logger.getLogger(MarsRoverDemo.class.getName());

    public static void main(String[] args) {

        try {

            List<String> commandList = InputUtil.readTextFile("input.txt");

            Plateau plateau = Plateau.intializePlateau(commandList.get(0));

            for (int i = 1; i < commandList.size(); i += 2) {

                try {
                    
                    if (InputUtil.isRoverCommandLinesEmpty(commandList.get(i), commandList.get(i + 1))) {
                        throw new RoverCommandsUnavailable("Commands are invalid");
                    }

                    Rover rover = new Rover();
                    rover.deployRover(plateau, commandList.get(i));
                    rover.processMovements(commandList.get(i + 1));
                    rover.printCoordinatesAndDirection();

                } catch (InvalidCommandException | InvalidPositionException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                } catch (Exception e) {
                    throw e;
                }
            }

        } catch (NoSuchFileException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}
