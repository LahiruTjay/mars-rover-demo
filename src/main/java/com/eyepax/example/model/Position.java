package com.eyepax.example.model;

public class Position {

    private int coordX;
    private int coordY;

    public Position(int coordX, int coordY) {
        super();
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

}
