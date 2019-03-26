package com.eyepax.example.model.direction;

public class SouthDirection implements Direction {

    @Override
    public Direction turnRight() {
        return new WestDirection();
    }

    @Override
    public Direction turnLeft() {
        return new EastDirection();
    }

}
