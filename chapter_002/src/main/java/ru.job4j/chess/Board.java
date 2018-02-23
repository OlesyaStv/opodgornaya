package ru.job4j.chess;

public class Board {

    private Figure[] figures = new Figure[32];
    private int position = 0;

    private Figure takeFigure(Cell source) {
        for (Figure f: figures) {
            if ((f != null) && f.position.theSame(source)) {
                return f;
            }
        }
        return null;
    }

    private boolean checkWay(Cell[] wayCell) {
        boolean haveProblem = false;

        for (int i = 0; i < wayCell.length - 1; i++) {
            Figure fig = takeFigure(wayCell[i]);
            if ((fig != null) && !(fig instanceof Bishop)) {
                haveProblem = true;
                break;
            }
        }
        Figure figOnTheAndWay = takeFigure(wayCell[wayCell.length - 1]);
        if (figOnTheAndWay != null) {
            haveProblem = true;
        }
        return  haveProblem;
    }

    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean allOk = true;
        Figure myFigura = takeFigure(source);
        if (myFigura == null) {
            try {
                throw new FigureNotFoundException("Figure not found!");
            } catch (FigureNotFoundException fnf) {
                allOk = false;
                System.out.println("Figure not found exception!");
            }
        } else {
            try {
                Cell[] wayCell = myFigura.way(source, dest);
                try {
                    if (checkWay(wayCell)) {
                        throw new ImposibleMoveException("Imposible move exception");
                    }
                } catch (OccupiedWayException moe) {
                    allOk = false;
                    System.out.println("Imposible move exception!");
                }
            } catch (ImposibleMoveException moe) {
                allOk = false;
                System.out.println("Imposible move exception!");
            }
        }

        if (allOk) {
            myFigura.copy(dest);
        }

        return  allOk;
    }

    public void add(Figure figure) {
        this.figures[this.position++] = figure;
    }

    public static void main(String[] args) {
        Board b = new Board();
        Bishop bishop = new Bishop(new Cell(1, 0));
        Bishop bishop2 = new Bishop(new Cell(3, 2));
        b.add(bishop);
        b.add(bishop2);
        b.move(new Cell(1, 0), new Cell(2, 2));
    }
}
