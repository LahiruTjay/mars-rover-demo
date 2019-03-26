package com.eyepax.example.direction;

public class DirectionLookUp {

    public static Direction getDirectionFromCommand(String direction) {
        switch (direction) {
        case "N":
            return new NorthDirection();
        case "E":
            return new EastDirection();
        case "S":
            return new SouthDirection();
        case "W":
            return new WestDirection();
        default:
            return null;
        }
    }

    public static <T extends Direction> String getDirection(T direction) {
        if (direction instanceof NorthDirection) {
            return "N";
        } else if (direction instanceof EastDirection) {
            return "E";
        } else if (direction instanceof WestDirection) {
            return "W";
        } else {
            return "S";
        }
    }

}
