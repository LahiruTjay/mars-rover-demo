package com.eyepax.example.model.direction;

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
