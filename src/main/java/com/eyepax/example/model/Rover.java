package com.eyepax.example.model;

import java.util.List;

import com.eyepax.example.direction.Direction;
import com.eyepax.example.direction.DirectionLookUp;
import com.eyepax.example.direction.EastDirection;
import com.eyepax.example.direction.NorthDirection;
import com.eyepax.example.direction.SouthDirection;
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

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void setPreviousPositions(List<Position> previousPositions) {
        this.previousPositions = previousPositions;
    }

    public List<Position> getPreviousPositions() {
        return previousPositions;
    }

    public Direction getFacingDirection() {
        return facingDirection;
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
                this.setFacingDirection(DirectionLookUp.getDirectionFromCommand(direction));
            } else {
                throw new InvalidPositionException("Invalid Rover deplpyment position");
            }

        } else {
            throw new InvalidCommandException("Invalid Rover deployment command");
        }
    }

    public void processMovements(String commands) {
        if (isRoverCommandValid(commands)) {
            for (char command : commands.toCharArray()) {
                movement(command);
            }
        } else {
            throw new InvalidCommandException("Invalid Rover movement command");
        }
    }

    private void movement(char command) {
        switch (command) {
        case 'M':
            Position position = this.scoutPosition();
            if (isValidPosition(this.plateau, position)) {
                moveForward(position);
            } else {
                throw new InvalidPositionException("Invalid Rover movement position");
            }
            break;
        case 'R':
            this.setFacingDirection(facingDirection.turnRight());
            break;
        case 'L':
            this.setFacingDirection(facingDirection.turnLeft());
            break;
        default:
            break;
        }
    }

    private Position scoutPosition() {
        Position position = new Position(this.currentPosition.getCoordX(), this.currentPosition.getCoordY());
        if (facingDirection instanceof NorthDirection) {
            position.setCoordY(this.currentPosition.getCoordY() + 1);
        } else if (facingDirection instanceof EastDirection) {
            position.setCoordX(this.currentPosition.getCoordX() + 1);
        } else if (facingDirection instanceof SouthDirection) {
            position.setCoordY(this.currentPosition.getCoordY() - 1);
        } else {
            position.setCoordX(this.currentPosition.getCoordX() - 1);
        }
        return position;
    }

    private void moveForward(Position position) {
        this.setCurrentPosition(position);
    }

    public String getCoordinatesAndDirection() {
        return String.format("%x %x %s", currentPosition.getCoordX(), currentPosition.getCoordY(), facingDirection.getDirection(facingDirection));
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
