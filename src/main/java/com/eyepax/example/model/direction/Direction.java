package com.eyepax.example.model.direction;

public interface Direction {

    /**
     * This methods turns the direction to right based on the current direction.
     * 
     * @return Subclass implementing the {@link Direction} interface.
     */
    Direction turnRight();

    /**
     * This methods turns the direction to left based on the current direction.
     * 
     * @return Subclass implementing the {@link Direction} interface.
     */
    Direction turnLeft();
}
