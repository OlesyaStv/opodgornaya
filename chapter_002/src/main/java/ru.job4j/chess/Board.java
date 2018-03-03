package ru.job4j.chess;

public class Board {

    private Figure[] figures = new Figure[32];
    private int position = 0;

    public Figure[] getFigures() {
        return figures;
    }

    public int getPosition() {
        return position;
    }

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
        try {
            if (myFigura == null) {
                throw new FigureNotFoundException("Figure not found!");
            } else {
                Cell[] wayCell = myFigura.way(source, dest);
                if (checkWay(wayCell)) {
                    throw new ImposibleMoveException("Imposible move exception");
                }
            }
        } catch (FigureNotFoundException fnf) {
            allOk = false;
            System.out.println("Figure not found exception!");
        } catch (OccupiedWayException moe) {
            allOk = false;
            System.out.println("Imposible move exception!");
        } catch (ImposibleMoveException moe) {
            allOk = false;
            System.out.println("Imposible move exception!");
        }
        if (allOk) {
            add(myFigura.copy(dest));
        }
        return  allOk;
    }

    public void add(Figure figure) {
        this.figures[this.position++] = figure;
    }

}
