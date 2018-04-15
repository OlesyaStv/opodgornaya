package ru.job4j.simpleset;

import java.util.Iterator;
import ru.job4j.generic.SimpleArray;

public class SimpleSetNew<E>  implements Iterable<E> {

    private SimpleArray simpleArray;

    public int size() {
       return simpleArray.size();
    }

    public boolean elementIsFind(E e) {
        boolean elementIsFind = false;
        for (int cell = 0; cell < simpleArray.getIndex(); cell++) {
            if (e.equals(simpleArray.get(cell))) {
                elementIsFind = true;
            }
        }
        return elementIsFind;
    }

    public void add(E e) {
        if (!elementIsFind(e)) {
            simpleArray.add(e);
        }
    }

    public SimpleSetNew(int size) {
        simpleArray = new SimpleArray(size);
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return simpleArray.hasNext();
            }
            @Override
            public E next() {
                return (E) simpleArray.next();
            }
        };
    }
}
