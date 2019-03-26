package com.eyepax.example.model;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.exception.InvalidPositionException;

public class Plateau {

    private static Plateau instance;
    private int upperBoundX;
    private int upperBoundY;

    private Plateau(int upperBoundX, int upperBoundY) {
        super();
        this.upperBoundX = upperBoundX;
        this.upperBoundY = upperBoundY;
    }

    public int getUpperBoundX() {
        return upperBoundX;
    }

    public int getUpperBoundY() {
        return upperBoundY;
    }

    /**
     * This method initialize the plateau using the coordinates given in the format of a string.
     * This method validates the string and throws proper exceptions.
     * Returns one instance of the plateau object as the class implements a singleton pattern.
     * 
     * @param plateauCoordinates - String containing coordinates for the plateau
     * @return Instance of {@link Plateau} class
     */
    public static Plateau intializePlateau(String plateauCoordinates) {
        if (instance == null) {
            if (isPlateauInitializationValid(plateauCoordinates)) {
                String[] inputArray = plateauCoordinates.split(" ");
                int upperBoundX = Integer.parseInt(inputArray[0]);
                int upperBoundY = Integer.parseInt(inputArray[1]);
                if (isPlateauCoordinatesValid(upperBoundX, upperBoundY)) {
                    instance = new Plateau(upperBoundX, upperBoundY);
                } else {
                    throw new InvalidPositionException("Invalid plateau initilization postion");
                }
            } else {
                throw new InvalidCommandException("Invalid Plateau initilization command");
            }
        }
        return instance;
    }

    /**
     * Validates the command given using regex matching.
     * 
     * @param command - String command
     * @return boolean returning regex matching of the command
     */
    private static boolean isPlateauInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+");
    }

    /**
     * Validates if the coordinates provided.
     * 
     * @param x - int upper X coordinate of the Plateau
     * @param y - int upper Y coordinate of the Plateau
     * @return boolean returning the coordinate validation
     */
    private static boolean isPlateauCoordinatesValid(int x, int y) {
        return (!(x == 0 && y == 0) || x < 0 || y < 0);
    }

}
