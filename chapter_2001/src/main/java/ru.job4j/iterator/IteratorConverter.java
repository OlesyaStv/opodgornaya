package ru.job4j.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConverter implements Iterator {

    private int[][] values;
    private int indexI = 0;
    private int indexJ = 0;

    public IteratorConverter(int[][] values){
        this.values = values;
    }

    public int getIndexI() {
        return indexI;
    }

    public int getIndexJ() {
        return indexJ;
    }

    public void setIndexI(int indexI) {
        this.indexI = indexI;
    }

    public void setIndexJ(int indexJ) {
        this.indexJ = indexJ;
    }

    @Override
    public boolean hasNext() {
        return values.length > getIndexI() && values[getIndexI()].length > getIndexJ();
    }

    @Override
    public Object next() throws NoSuchElementException{
        Object ob = null;
        for (int i = getIndexI(); i < values.length; i++) {
            for (int j = getIndexJ(); j < values[i].length; j++){
                ob =  values[i][j];
                if (j + 1 == values[i].length){
                    setIndexI(i + 1);
                    setIndexJ(0);
                } else if(j + 1 < values[i].length){
                    setIndexJ(j + 1);
                }
                break;
            }
            break;
        }

        if (ob == null) {
            throw new NoSuchElementException();
        }
        return ob;
    }
}
