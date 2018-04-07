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
               // return current.hasNext() || parent.hasNext();
                boolean hN = false;
                if (current.hasNext()) {
                    hN =  true;
                } else {
                    if (it.hasNext()) {
                        current = it.next();
                        if (current.hasNext()) {
                            hN =  true;
                        }
                    }
                }
                return hN;
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
