package com.eyepax.example.model.direction;

public class NorthDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new EastDirection();
    }

    @Override
    public Direction turnLeft() {
        return new WestDirection();
    }

}
