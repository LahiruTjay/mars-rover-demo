package com.eyepax.example.model;

import java.util.List;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.exception.InvalidPositionException;

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
                throw new InvalidPositionException("Invalid position");
            }

        } else {
            throw new InvalidCommandException("Invalid command");
        }

    }

    public void processMovements(String commands) {
        if (isRoverCommandValid(commands)) {
            for (char command : commands.toCharArray()) {
                movement(command);
                System.out.println(this.getCoordinatesAndDirection());
            }
        } else {
            throw new InvalidCommandException("Invalid commands");
        }
    }

    private void movement(char command) {
        switch (command) {
        case 'M':
            Position position = this.scoutPosition();
            if (isValidPosition(this.plateau, position)) {
                moveForward(position);
            } else {
                System.out.println("Invalid move");
            }
            break;
        case 'R':
            this.setFacingDirection(getFacingDirection(this.facingDirection, TurningDirection.RIGHT));
            break;
        case 'L':
            this.setFacingDirection(getFacingDirection(this.facingDirection, TurningDirection.LEFT));
            break;
        default:
            break;
        }
    }

    private Position scoutPosition() {
        Position position = new Position(this.currentPosition.getCoordX(), this.currentPosition.getCoordY());
        switch (this.facingDirection) {
        case NORTH:
            position.setCoordY(this.currentPosition.getCoordY() + 1);
            break;
        case EAST:
            position.setCoordX(this.currentPosition.getCoordX() + 1);
            break;
        case SOUTH:
            position.setCoordY(this.currentPosition.getCoordY() - 1);
            break;
        case WEST:
            position.setCoordX(this.currentPosition.getCoordX() - 1);
            break;
        default:
            break;
        }
        return position;
    }

    private void moveForward(Position position) {
        this.setCurrentPosition(position);
    }

    private Direction getFacingDirection(Direction currentDirection, TurningDirection newDirection) {
        int directionsCount = Direction.values().length;
        int dir = (directionsCount + currentDirection.getDirectionValue() + newDirection.getOrientationValue()) % directionsCount;
        return Direction.getDirectionByValue(dir);
    }

    public String getCoordinatesAndDirection() {
        return String.format("%x %x %s", this.currentPosition.getCoordX(), this.currentPosition.getCoordY(), this.facingDirection.getDirection());
    }

    public void printCoordinatesAndDirection() {
        System.out.println(getCoordinatesAndDirection());
    }

    private boolean isRoverInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+\\s[NESW]");
    }

    private static boolean isRoverCommandValid(String commands) {
        return commands.trim().matches("[MLR]+");
    }

    private boolean isValidPosition(Plateau plateau, Position position) {
        if (position.getCoordX() < 0 || position.getCoordX() > plateau.getUpperBoundX()) {
            return false;
        } else if (position.getCoordY() < 0 || position.getCoordY() > plateau.getUpperBoundY()) {
            return false;
        }
        return true;
    }

}
