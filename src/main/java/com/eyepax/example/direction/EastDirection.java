package com.eyepax.example.direction;

public class EastDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new SouthDirection();
    }

    @Override
    public Direction turnLeft() {
        return new NorthDirection();
    }

}
