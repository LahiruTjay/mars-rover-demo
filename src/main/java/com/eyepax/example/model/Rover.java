package com.eyepax.example.model;

import com.eyepax.example.exception.InvalidCommandException;
import com.eyepax.example.exception.InvalidPositionException;
import com.eyepax.example.model.direction.Direction;
import com.eyepax.example.model.direction.DirectionLookUp;
import com.eyepax.example.model.direction.EastDirection;
import com.eyepax.example.model.direction.NorthDirection;
import com.eyepax.example.model.direction.SouthDirection;

public class Rover {

    private Plateau plateau;
    private Position currentPosition;
    private Direction facingDirection;

    private Rover(Plateau plateau, Position currentPosition, Direction facingDirection) {
        super();
        this.plateau = plateau;
        this.currentPosition = currentPosition;
        this.facingDirection = facingDirection;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    /**
     * This method initialize a rover using the coordinates and the direction given in the format of a string.
     * This method validates the input command. 
     * @throws {@link InvalidCommandException} if command is invalid and throws {@link InvalidPositionException} if the deployment position is invalid.
     * Returns an object of the Rover.
     * 
     * @param plateau - instance of {@link Plateau}
     * @param command - String command used to provide coordinates and direction
     * @return Instance of {@link Plateau} class
     */
    public static Rover deployRover(Plateau plateau, String command) {

        if (isRoverInitializationValid(command)) {

            String[] inputArray = command.split(" ");
            int coordX = Integer.parseInt(inputArray[0]);
            int coordY = Integer.parseInt(inputArray[1]);
            String direction = inputArray[2];

            Position position = new Position(coordX, coordY);
            if (isValidPosition(plateau, position)) {

                return initializeRover(plateau, position, DirectionLookUp.getDirectionFromCommand(direction));

            } else {
                throw new InvalidPositionException("Invalid Rover deplpyment position");
            }

        } else {
            throw new InvalidCommandException("Invalid Rover deployment command");
        }
    }

    /**
     * Initializes {@link Rover} using a private constructor.
     * 
     * @param plateau
     * @param position
     * @param direction
     * @return Instance of {@link Rover} class
     */
    private static Rover initializeRover(Plateau plateau, Position position, Direction direction) {
        return new Rover(plateau, position, direction);
    }

    /**
     * Method to carry out movements of the Rover.
     * Validates the movement and performs the movement.
     * @throws {@link InvalidCommandException} if the command is invalid.
     * 
     * @param commands - String containing coordinates and direction of movement.
     */
    public void processMovements(String commands) {
        if (isRoverCommandValid(commands)) {
            for (char command : commands.toCharArray()) {
                movement(command);
            }
        } else {
            throw new InvalidCommandException("Invalid Rover movement command");
        }
    }

    /**
     * This method performs the actual movement.
     * Movement can be M - Move forward, R - Turn Right and L - Turn left
     * @throws {@link InvalidPositionException} if the movement position is not within {@link Plateau} coordinates.
     * 
     * @param command
     */
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
            this.facingDirection = facingDirection.turnRight();
            break;
        case 'L':
            this.facingDirection = facingDirection.turnLeft();
            break;
        default:
            break;
        }
    }

    /**
     * This method acts as a scout for the rover before the rover actually makes a movement.
     * This method returns a {@link Position} object based on the direction of the rover.
     * This method retrieves the current coordinates of the rover and update coordinates based on the facing direction.
     * 
     * @return Instance of {@link Position} class
     */
    private Position scoutPosition() {
        Position position = new Position(currentPosition.getCoordX(), currentPosition.getCoordY());
        if (facingDirection instanceof NorthDirection) {
            position.setCoordY(currentPosition.getCoordY() + 1);
        } else if (facingDirection instanceof EastDirection) {
            position.setCoordX(currentPosition.getCoordX() + 1);
        } else if (facingDirection instanceof SouthDirection) {
            position.setCoordY(currentPosition.getCoordY() - 1);
        } else {
            position.setCoordX(currentPosition.getCoordX() - 1);
        }
        return position;
    }

    /**
     * Updates the current position of the {@link Rover}
     * 
     * @param position - {@link Position} object
     */
    private void moveForward(Position position) {
        this.currentPosition = position;
    }

    /**
     * This method returns the current coordinates and the facing direction of the Rover in the given format.
     * 
     * @return String returns current coordinates and facing direction.
     */
    public String getCoordinatesAndDirection() {
        return String.format("%x %x %s", currentPosition.getCoordX(), currentPosition.getCoordY(), DirectionLookUp.getDirection(facingDirection));
    }

    /**
     * This method print current coordinates and the facing direction of the Rover in the given format.
     */
    public void printCoordinatesAndDirection() {
        System.out.println(getCoordinatesAndDirection());
    }

    /**
     * Validates the {@link Rover} initialization command given using regex matching.
     * 
     * @param command - String command.
     * @return boolean returning regex matching of the command.
     */
    private static boolean isRoverInitializationValid(String command) {
        return command.trim().matches("\\d+\\s\\d+\\s[NESW]");
    }

    /**
     * Validates the {@link Rover} movement command given using regex matching.
     * 
     * @param command - String command.
     * @return boolean returning regex matching of the command.
     */
    private static boolean isRoverCommandValid(String commands) {
        return commands.trim().matches("[MLR]+");
    }

    /**
     * This method validates the position of the rover object after scouting.
     * This checks whether the coordinates of the position is within the {@link Plateau} limits.
     * 
     * @param plateau {@link Plateau} object
     * @param position {@link Position} current position after scouting
     * @return boolean - validity of the position.
     */
    private static boolean isValidPosition(Plateau plateau, Position position) {
        if (position.getCoordX() < 0 || position.getCoordX() > plateau.getUpperBoundX()) {
            return false;
        } else if (position.getCoordY() < 0 || position.getCoordY() > plateau.getUpperBoundY()) {
            return false;
        }
        return true;
    }

}
