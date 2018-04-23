package ru.job4j.hash;

import static java.lang.System.arraycopy;

public class HashSetOld<E> {

    private int countCell;
    private Object[] objects;
    private Integer indexForHash;
    private Integer indexForTable;

    public int returnHash() {
        int hashCode = indexForHash.hashCode();
        this.indexForHash++;
        return hashCode;
    }

    public boolean contains(E e) {
        boolean containObject = false;
        for (int start = 0; start < objects.length; start++) {
            PairEntry pairEntry = (PairEntry) objects[start];
            if (pairEntry != null && !containObject && !pairEntry.getEmpty() && pairEntry.getValue().equals(e)) {
                containObject = true;
            }
        }
        return  containObject;
    }

    private void addFreeCells() {
        Object[] newObjects = new Object[countCell * 2];
        arraycopy(objects, 0, newObjects, 0, countCell);
        this.objects = newObjects;
        this.countCell = countCell * 2;
    }

    public boolean remove(E e) {
        boolean wasRemoved = false;
        for (int start = 0; start < objects.length; start++) {
            PairEntry pairEntry = (PairEntry) objects[start];
            if (!wasRemoved && !pairEntry.getEmpty() && pairEntry.getValue().equals(e)) {
                pairEntry.setEmpty();
                wasRemoved = true;
            }
        }
        return wasRemoved;
    }

    public boolean add(E e) {
        boolean wasAdded = false;
        if (!contains(e)) {
            int h = (int) returnHash();
            PairEntry pairEntry = new PairEntry<>(h, e);
            if (indexForTable > this.countCell) {
                addFreeCells();
            }
            objects[indexForTable++] = pairEntry;
            wasAdded = true;
        }
        return wasAdded;
    }

    public HashSetOld(int countCell) {
        this.objects = new Object[countCell];
        this.countCell = countCell;
        this.indexForHash = 0;
        this.indexForTable = 0;
    }
}
