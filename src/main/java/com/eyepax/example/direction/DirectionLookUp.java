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

}
