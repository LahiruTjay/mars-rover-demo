package com.eyepax.example.model.direction;

public class WestDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new NorthDirection();
    }

    @Override
    public Direction turnLeft() {
        return new SouthDirection();
    }

}
