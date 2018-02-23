package ru.job4j.chess;


public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    };

    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {

        boolean canGo = false;
        boolean xFirst = false;
        int xDest = dest.x;
        int yDest = dest.y;
        int xSource = source.x;
        int ySource = source.y;

        if (((xDest == xSource + 2) || (xDest == xSource - 2)) && ((yDest == ySource + 1) || (yDest == ySource + 1))) {
            canGo = true;
            xFirst = true;
        } else if (((yDest == ySource + 2) || (yDest == ySource - 2)) && ((xDest == xSource + 1) || (xDest == xSource + 1))) {
            canGo = true;
            xFirst = false;
        }
        if (canGo) {
            Cell[] wayCell = new Cell[3];
            if (xFirst) {
                wayCell[0] = new Cell(++xSource, ySource);
                wayCell[1] = new Cell(++xSource, ySource);
                if (yDest == source.y + 1) {
                    wayCell[2] = new Cell(xSource, ++ySource);
                } else {
                    wayCell[2] = new Cell(xSource, --ySource);
                }
            } else {
                wayCell[0] = new Cell(xSource, ++ySource);
                wayCell[1] = new Cell(xSource, ++ySource);
                if (xDest == source.x + 1) {
                    wayCell[2] = new Cell(++xSource, ySource);
                } else {
                    wayCell[2] = new Cell(--xSource, ySource);
                }
            }
            return  wayCell;
        } else {
            throw new ImposibleMoveException("Impossible move!");
        }
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

}
