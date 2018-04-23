package ru.job4j.hash;

import static java.lang.System.arraycopy;

public class HashSet<E> {

    private int countCell;
    private Object[] objects;

    public int returnHash(E e) {
        return e.hashCode();
    }

    public boolean contains(E e) {
        boolean containObject = false;
        int hashCode = returnHash(e);
        if (hashCode < objects.length) {
            PairEntry pairEntry = (PairEntry) objects[hashCode];
            if (pairEntry != null  && !pairEntry.getEmpty()) {
                containObject = true;
            }
        }
        return  containObject;
    }

    private void addFreeCells(int hashCode) {
        while (hashCode > this.countCell) {
            Object[] newObjects = new Object[countCell * 2];
            arraycopy(objects, 0, newObjects, 0, countCell);
            this.objects = newObjects;
            this.countCell = countCell * 2;
        }
    }

    public boolean remove(E e) {
        boolean wasRemoved = false;
        if (contains(e)) {
            PairEntry pairEntry = (PairEntry) objects[returnHash(e)];
            pairEntry.setEmpty();
            wasRemoved = true;
        }
        return wasRemoved;
    }

    public boolean add(E e) {
        boolean wasAdded = false;
        if (!contains(e)) {
            int hashCode = returnHash(e);
            PairEntry pairEntry = new PairEntry(hashCode, e);
            addFreeCells(hashCode);
            objects[hashCode] = pairEntry;
            wasAdded = true;
        }
        return wasAdded;
    }

    public HashSet(int countCell) {
        this.objects = new Object[countCell];
        this.countCell = countCell;
    }
}
