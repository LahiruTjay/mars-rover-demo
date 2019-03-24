package com.eyepax.example.model;

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

    public void setUpperBoundX(int upperBoundX) {
        this.upperBoundX = upperBoundX;
    }

    public int getUpperBoundY() {
        return upperBoundY;
    }

    public void setUpperBoundY(int upperBoundY) {
        this.upperBoundY = upperBoundY;
    }

    public static Plateau intializePlateau(String plateauCoordinates) {
        if (instance == null) {
            if (isPlateauInitializationValid(plateauCoordinates)) {
                instance = parseAndInitialize(plateauCoordinates);
            } else {
                throw new RuntimeException("Invalid command");
            }
        }
        return instance;
    }

    public static boolean isPlateauInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+");
    }

    public static Plateau parseAndInitialize(String plateauCoordinates) {
        String[] inputArray = plateauCoordinates.split(" ");
        int upperBoundX = Integer.parseInt(inputArray[0]);
        int upperBoundY = Integer.parseInt(inputArray[1]);
        return new Plateau(upperBoundX, upperBoundY);
    }

    @Override
    public String toString() {
        return "Plateau [upperBoundX=" + upperBoundX + ", upperBoundY=" + upperBoundY + "]";
    }

}
