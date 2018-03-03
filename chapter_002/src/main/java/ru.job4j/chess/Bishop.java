package ru.job4j.chess;


public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    };


//    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
//        boolean canGo = false;
//        int xDest = dest.x;
//        int yDest = dest.y;
//        int xCoord = source.x;
//        int yCoord = source.y;
//        int kolPoY = Math.abs(yDest - yCoord);
//        int kolPoX = Math.abs(xDest - xCoord);
//        int kol = kolPoX + kolPoY;
//        if (kol == 3 && (((kolPoX == 1) && (kolPoY == 2)) || ((kolPoX == 2) && (kolPoY == 1)))) {
//            canGo = true;
//        }
//        if (canGo) {
//            Cell[] wayCell = new Cell[3];
//            int index = 0;
//            int deltaX = Integer.compare(xDest, xCoord);
//            int deltaY = Integer.compare(yDest, yCoord);
//            while ((deltaX + deltaY) != 0) {
//                if (Math.abs(xDest - xCoord) >= Math.abs(yDest - yCoord)) {
//                    while (deltaX != 0) {
//                        xCoord += deltaX;
//                        wayCell[index] = new Cell(xCoord, yCoord);
//                        index++;
//                        deltaX = Integer.compare(xDest, xCoord);
//                    }
//                } else {
//                    while (deltaY != 0) {
//                        yCoord += deltaY;
//                        wayCell[index] = new Cell(xCoord, yCoord);
//                        index++;
//                        deltaY = Integer.compare(yDest, yCoord);
//                    }
//                }
//            }
//            return  wayCell;
//        } else {
//            throw new ImposibleMoveException("Impossible move!");
//        }
//    }

    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        boolean canGo = false;
        boolean xFirst = false;
        int xDest = dest.x;
        int yDest = dest.y;
        int xCoord = source.x;
        int yCoord = source.y;
        int kolPoY = Math.abs(yDest - yCoord);
        int kolPoX = Math.abs(xDest - xCoord);
        int kol = kolPoX + kolPoY;
        if (kol == 3 && (((kolPoX == 1) && (kolPoY == 2)) || ((kolPoX == 2) && (kolPoY == 1)))) {
            canGo = true;
            if (kolPoX == 2) {
                xFirst = true;
            }
        }
        if (canGo) {
            Cell[] wayCell = new Cell[3];
            int index = 0;
            while (xCoord != xDest || yCoord != yDest) {
                int deltaX = Integer.compare(xDest, xCoord);
                int deltaY = Integer.compare(yDest, yCoord);
                if (xFirst) {
                    deltaY = 0;
                } else {
                    deltaX = 0;
                }
                xCoord += deltaX;
                yCoord += deltaY;
                wayCell[index] = new Cell(xCoord, yCoord);
                index++;
                if (xCoord == xDest) {
                    xFirst = false;
                }
                if (yCoord == yDest) {
                    xFirst = true;
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
