package com.eyepax.example.model;

import java.util.List;

public class Rover {

    private String name;
    private Plateau plateau;
    private Position currentPosition;
    private Direction facingDirection;
    private List<Position> previousPositions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public List<Position> getPreviousPositions() {
        return previousPositions;
    }

    public void setPreviousPositions(List<Position> previousPositions) {
        this.previousPositions = previousPositions;
    }

    
    
    
}
