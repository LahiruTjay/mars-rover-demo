package com.eyepax.example.model;

public enum Direction {

    NORTH("N", 0), EAST("E", 1), SOUTH("S", 2), WEST("W", 3);

    private String direction;
    private int directionValue;

    private Direction(String direction, int directionValue) {
        this.direction = direction;
        this.directionValue = directionValue;
    }

    public String getDirection() {
        return direction;
    }

    public int getDirectionValue() {
        return directionValue;
    }

    public static Direction getDirection(int direction) {
        for (Direction e : Direction.values()) {
            if (e.directionValue == direction) {
                return e;
            }
        }
        return null;
    }
}
