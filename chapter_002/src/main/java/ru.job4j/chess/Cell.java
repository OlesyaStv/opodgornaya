package ru.job4j.chess;

public class Cell {

    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean theSame(Cell point) {
        boolean theSame = false;
        if ((point.x  ==  this.x)  && (point.y == this.y)) {
            theSame = true;
        }
        return  theSame;
    }

}
