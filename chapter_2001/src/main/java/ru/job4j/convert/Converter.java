package ru.job4j.convert;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private  Iterator<Integer> current;
    private Iterator<Iterator<Integer>> parent;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.current = it.next();
        this.parent = it;
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (current.hasNext()) {
                    hasNext =  true;
                } else {
                    if (it.hasNext()) {
                        current = it.next();
                        if (current.hasNext()) {
                            hasNext =  true;
                        }
                    }
                }
                return hasNext;
            }
            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer ob = null;
                if (!current.hasNext()) {
                    current = parent.next();
                    while (current.hasNext()) {
                        ob = current.next();
                        break;
                    }
                } else {
                    while (current.hasNext()) {
                        ob = current.next();
                        break;
                    }
                }
                return ob;
            }
        };
    }
}
