package ru.job4j.evenIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] values;
    private int index = 0;

    public EvenIterator(int[] values){
        this.values = values;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public boolean hasNext() {
        boolean hasN = false;
        for (int ind = getIndex(); ind  < values.length; ind++) {
            if(this.values[ind] % 2 == 0) {
                hasN = true;
                break;
            }
        }
        return hasN;
    }

    @Override
    public Object next() throws NoSuchElementException {
        Object ob = null;
        for (int ind = getIndex(); ind  < values.length; ind++) {
            if(this.values[ind] % 2 == 0) {
                ob = this.values[ind];
                setIndex(ind + 1);
                break;
            }
        }
        if (ob == null) {
            throw new NoSuchElementException();
        }
        return ob;
    }
}
