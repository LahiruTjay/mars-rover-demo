package com.eyepax.example.model;

public enum TurningDirection {

    RIGHT("R", +1), LEFT("L", -1);

    private String orientation;
    private int orientationValue;

    private TurningDirection(String orientation, int orientationValue) {
        this.orientation = orientation;
        this.orientationValue = orientationValue;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getOrientationValue() {
        return orientationValue;
    }
}
