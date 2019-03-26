package com.eyepax.example.model.direction;

public class DirectionLookUp {

    /**
     * This method is used return the classes implementing Direction class.
     * Return is of the class based on a input character.
     * 
     * @param direction - String direction 
     * @return Sub classes of Direction interface
     */
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

    /**
     * This method return a String prefix for the direction.
     * Return values are based on the instances of the sub classes of Direction
     * 
     * @param direction - Subclasses implementing Direction
     * @return String value character for direction
     */
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
