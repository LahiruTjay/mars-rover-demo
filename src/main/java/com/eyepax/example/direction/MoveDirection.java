package com.eyepax.example.direction;

public enum MoveDirection {

    NORTH("N", 0), EAST("E", 1), SOUTH("S", 2), WEST("W", 3);

    private String direction;
    private int directionValue;

    private MoveDirection(String direction, int directionValue) {
        this.direction = direction;
        this.directionValue = directionValue;
    }

    public String getDirection() {
        return direction;
    }

    public int getDirectionValue() {
        return directionValue;
    }

    public static MoveDirection getDirection(String direction) {
        for (MoveDirection e : MoveDirection.values()) {
            if (direction.equals(e.direction)) {
                return e;
            }
        }
        return null;
    }

    public static MoveDirection getDirectionByValue(int direction) {
        for (MoveDirection e : MoveDirection.values()) {
            if (e.directionValue == direction) {
                return e;
            }
        }
        return null;
    }
}
