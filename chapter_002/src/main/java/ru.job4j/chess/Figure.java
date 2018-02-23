package ru.job4j.chess;

public abstract class Figure {

    public final Cell position;

    public Figure(Cell position) {
        this.position = position;
    };

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copy(Cell dest);
}
