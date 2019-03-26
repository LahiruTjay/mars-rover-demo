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

    private static boolean isPlateauInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+");
    }

    private static boolean isPlateauCoordinatesValid(int x, int y) {
        return (!(x == 0 && y == 0) || x < 0 || y < 0);
    }

}
