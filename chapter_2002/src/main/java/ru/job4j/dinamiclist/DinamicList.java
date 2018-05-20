package ru.job4j.dinamiclist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DinamicList<E> implements Iterable<E> {

    @GuardedBy("this")
    private Object[] container;
    @GuardedBy("this")
    private int modCount;
    @GuardedBy("this")
    private int cell;

    private int nextIndex;

    public synchronized int getRealLength() {
        return this.container.length;
    }

    private synchronized void enlarge() {
        if (cell == container.length) {
            int sizeShouldBe = container.length * 2;
            Object[] newContainer = new Object[sizeShouldBe];
            System.arraycopy(this.container, 0, newContainer, 0, this.container.length);
            this.container = newContainer;
        }
    }

    public synchronized void add(E value) {
        this.modCount++;
        enlarge();
        this.container[cell++] = value;
    }

    public synchronized E get(int cellF) {
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
