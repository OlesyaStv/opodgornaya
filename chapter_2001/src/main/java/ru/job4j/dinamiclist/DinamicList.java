package ru.job4j.dinamiclist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DinamicList<E> implements Iterable<E> {

    private Object[] container;
    private int modCount;
    private int cell;
    private int nextIndex;

    public int getRealLength() {
        return this.container.length;
    }

    private void enlarge() {
        if (cell == container.length) {
            int sizeShouldBe = container.length * 2;
            Object[] newContainer = new Object[sizeShouldBe];
            System.arraycopy(this.container, 0, newContainer, 0, this.container.length);
            this.container = newContainer;
        }
    }

    public void add(E value) {
        this.modCount++;
        enlarge();
        this.container[cell++] = value;
    }

    public E get(int cellF) {
        Object object = null;
        if (cellF <= cell - 1) {
            object = this.container[cellF];
        }
        if (Objects.nonNull(object)) {
            return (E) object;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {

        int expectedModCount = modCount;

        return new Iterator<E>() {
            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean hasN = false;
                if (nextIndex < container.length && (Objects.nonNull(container[nextIndex]))) {
                    hasN = true;
                }
                return hasN;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[nextIndex++];
            }
        };
    }

    public DinamicList(E[] container) {
        this.modCount = 0;
        this.container = container;
        this.cell = container.length;
        this.nextIndex = 0;
    }

}
