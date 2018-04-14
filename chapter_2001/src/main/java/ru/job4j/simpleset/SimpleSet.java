package ru.job4j.simpleset;

import java.util.Iterator;

public class SimpleSet<E>  implements Iterable {

    private E[] list;
    private int index = 0;

    public void add(E e) {
        boolean elementIsFind = false;

        for (int cell = 0; cell < list.length; cell++) {
            if (e.equals(list[cell])) {
                elementIsFind = true;
            }
        }
        if (!elementIsFind) {
            list[index++] = e;
        }
    }

    public int size() {
        return index;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return index < list.length;
            }
            @Override
            public E next() {
                return (E) list[index];
            }
        };
    }

    public SimpleSet(int size) {
        this.list = (E[]) (new Object[size]);
    }

    public SimpleSet() {
        this.list = (E[]) (new Object[100]);
    }
}
