package com.eyepax.example.direction;

public interface Direction {

    Direction turnRight();

    Direction turnLeft();

    default <T extends Direction> String getDirection(T direction) {
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
