package ru.job4j.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] values;
    private int cell = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean hasN = false;
        for (int ind = cell; ind  < values.length; ind++) {
            if (this.values[ind] % 2 == 0) {
                hasN = true;
                break;
            }
        }
        return hasN;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer nextEl = null;
        for (int ind = cell; ind  < values.length; ind++) {
            if (this.values[ind] % 2 == 0) {
                cell = ind + 1;
                nextEl =  this.values[ind];
                break;
            }
        }
        return nextEl;
    }
}
