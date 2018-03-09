package ru.job4j.chess;


public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    };
    //first
//    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
//        boolean canGo = false;
//        boolean xFirst = false;
//        int xDest = dest.x;
//        int yDest = dest.y;
//        int xCoord = source.x;
//        int yCoord = source.y;
//        int kolPoY = Math.abs(yDest - yCoord);
//        int kolPoX = Math.abs(xDest - xCoord);
//        int kol = kolPoX + kolPoY;
//        if (kol == 3 && (((kolPoX == 1) && (kolPoY == 2)) || ((kolPoX == 2) && (kolPoY == 1)))) {
//            canGo = true;
//            if (kolPoX == 2) {
//                xFirst = true;
//            }
//        }
//        if (canGo) {
//            Cell[] wayCell = new Cell[3];
//            int index = 0;
//            while (xCoord != xDest || yCoord != yDest) {
//                int deltaX = Integer.compare(xDest, xCoord);
//                int deltaY = Integer.compare(yDest, yCoord);
//                if (xFirst) {
//                    deltaY = 0;
//                } else {
//                    deltaX = 0;
//                }
//                xCoord += deltaX;
//                yCoord += deltaY;
//                wayCell[index] = new Cell(xCoord, yCoord);
//                index++;
//                if (xCoord == xDest) {
//                    xFirst = false;
//                }
//                if (yCoord == yDest) {
//                    xFirst = true;
//                }
//            }
//            return  wayCell;
//        } else {
//            throw new ImposibleMoveException("Impossible move!");
//        }
//    }


    //second
//    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
//        Cell[] wayCell = new Cell[3];
//        boolean xFirst = false;
//        int kolPoY = Math.abs(dest.y - source.y);
//        int kolPoX = Math.abs(dest.x - source.x);
//        if (kolPoX > kolPoY){
//            xFirst = true;
//        }
//        if (kolPoX * kolPoY == 2) {
//            int index = 0;
//            while (source.x != dest.x || source.y != dest.y) {
//                int deltaX = Integer.compare(dest.x, source.x);
//                int deltaY = Integer.compare(dest.y, source.y);
//                if (xFirst) {
//                    deltaY = 0;
//                } else {
//                    deltaX = 0;
//                }
//                wayCell[index] = new Cell(source.x += deltaX, source.y += deltaY);
//                index++;
//                if (source.x  == dest.x) {
//                    xFirst = false;
//                }
//                if (source.y == dest.y) {
//                    xFirst = true;
//                }
//            }
//        } else {
//            throw new ImposibleMoveException("Impossible move!");
//        }
//        return  wayCell;
//    }

    //third
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] wayCell = new Cell[3];
        int kolPoY = Math.abs(dest.y - source.y);
        int kolPoX = Math.abs(dest.x - source.x);
        boolean xFirst = false;
        if (kolPoX > kolPoY) {
            xFirst = true;
        }
        if (kolPoX * kolPoY == 2) {
            int index = 0;
            while (index != kolPoX + kolPoY){
                if (xFirst) {
                    int deltaX = Integer.compare(dest.x, source.x);
                    while (deltaX != 0) {
                        wayCell[index] = new Cell(source.x += deltaX, source.y);
                        deltaX = Integer.compare(dest.x, source.x);
                        index++;
                    }
                    xFirst = false;
                }else {
                    int deltaY = Integer.compare(dest.y, source.y);
                    while (deltaY != 0) {
                        wayCell[index] = new Cell(source.x, source.y += deltaY);
                        deltaY = Integer.compare(dest.y, source.y);
                        index++;
                    }
                    xFirst = true;
                }
            }
        }
        else {
            throw new ImposibleMoveException("Impossible move!");
        }
        return wayCell;
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

}
