package ru.job4j.hash;

import static java.lang.System.arraycopy;

public class HashSet<E> {

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
            Para para = (Para) objects[start];
            if (para != null && !containObject && !para.getEmpty() && para.getValue().equals(e)) {
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
            Para para = (Para) objects[start];
            if (!wasRemoved && !para.getEmpty() && para.getValue().equals(e)) {
                para.setEmpty();
                wasRemoved = true;
            }
        }
        return wasRemoved;
    }

    public boolean add(E e) {
        boolean wasAdded = false;
        if (!contains(e)) {
            int h = (int) returnHash();
            Para para = new Para(h, e);
            if (indexForTable > this.countCell) {
                addFreeCells();
            }
            objects[indexForTable++] = para;
            wasAdded = true;
        }
        return wasAdded;
    }

    public HashSet(int countCell) {
        this.objects = new Object[countCell];
        this.countCell = countCell;
        this.indexForHash = 0;
        this.indexForTable = 0;
    }
}
