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

    public void deployRover(Plateau plateau, String command) {

        if (isRoverInitializationValid(command)) {

            String[] inputArray = command.split(" ");
            int coordX = Integer.parseInt(inputArray[0]);
            int coordY = Integer.parseInt(inputArray[1]);
            String direction = inputArray[2];

            Position position = new Position(coordX, coordY);
            if (isValidPosition(plateau, position)) {
                this.setPlateau(plateau);
                this.setCurrentPosition(position);
                this.setFacingDirection(Direction.getDirection(direction));
            } else {
                throw new RuntimeException("Invalid position");
            }

        } else {
            throw new RuntimeException("Invalid command");
        }

    }

    public String getCoordinatesAndDirection() {
        return String.format("%x %x %s", this.currentPosition.getCoordX(), this.currentPosition.getCoordY(), this.facingDirection.getDirection());
    }

    public void printCoordinatesAndDirection() {
        System.out.println(getCoordinatesAndDirection());
    }

    public boolean isRoverInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+\\s[NESW]");
    }

    private boolean isValidPosition(Plateau plateau, Position position) {
        if (position.getCoordX() < 0 || position.getCoordX() > plateau.getUpperBoundX() - 1) {
            return false;
        } else if (position.getCoordY() < 0 || position.getCoordY() > plateau.getUpperBoundY() - 1) {
            return false;
        }
        return true;
    }

}
