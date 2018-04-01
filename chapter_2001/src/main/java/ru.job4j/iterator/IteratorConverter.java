package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConverter implements Iterator {

    private int[][] values;
    private int row = 0;
    private int cell = 0;

    public IteratorConverter(int[][] values){
        this.values = values;
    }

    @Override
    public boolean hasNext() {
      return (values.length != row && (values.length > row || values[row].length > cell));
    }

    @Override
    public Object next() throws NoSuchElementException{
        int result;
        if (hasNext()){
            if (values[row].length > cell){
                result = values[row][cell++];
                if (values[row].length == cell){
                    row++;
                    cell = 0;
                }
            }else {
                result = values[row][cell++];
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }
}
