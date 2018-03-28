package ru.job4j.сonverter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private  Iterator<Integer> current;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.current = it.next();
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                boolean hN = false;
                if (current.hasNext()) {
                    hN =  true;
                }else {
                    if (it.hasNext()){
                        current = it.next();
                        if(current.hasNext()){
                            hN =  true;
                        }
                    }
                }
                return hN;
            }

            @Override
            public Integer next() throws NoSuchElementException {
                Integer ob = null;
                if(!current.hasNext()) {
                    current = it.next();
                    while (current.hasNext()){
                        ob = current.next();
                        break;
                    }
                }else {
                    while (current.hasNext()){
                        ob = current.next();
                        break;
                    }
                }
                if (ob == null) {
                    throw new NoSuchElementException();
                }
                return ob;
            }
        };
    }
}
