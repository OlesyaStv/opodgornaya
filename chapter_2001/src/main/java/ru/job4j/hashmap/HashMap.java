package ru.job4j.hashmap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static java.lang.System.arraycopy;

public class HashMap<K, V> implements Iterable<K> {

    private int countCell;
    private Object[] objects;
    private int mapLength;
    private int index;
    private int indexForSearch;

    private void addFreeCells() {
        Object[] newObjects = new Object[countCell * 2];
        arraycopy(objects, 0, newObjects, 0, countCell);
        this.objects = newObjects;
        this.countCell = countCell * 2;
    }

    public boolean insert(K key, V value) {
        boolean insert = false;
        if (key != null) {
            while (key.hashCode() >= this.countCell) {
                addFreeCells();
            }
            Para para = (Para) objects[key.hashCode()];
            if (para == null || para.empty()) {
                objects[key.hashCode()] = new Para(key, value);
                insert = true;
                mapLength++;
            }
        }
        return insert;
    }

    public V get(K key) {
       V result = null;
       if (key.hashCode() < this.countCell && objects[key.hashCode()] != null) {
           Para para = (Para) objects[key.hashCode()];
           result = (V) para.getValue();
       }
       return result;
    }

    public boolean delete(K key) {
        boolean delete = false;
        if (get(key) != null) {
            Para para = (Para) objects[key.hashCode()];
            para.delete();
            delete = true;
            mapLength--;
        }
        return delete;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return index < mapLength;
            }
            @Override
            public K next() {
                index++;
                K result = null;
                if (indexForSearch < objects.length) {
                    for (int cell = indexForSearch; cell < objects.length; cell++) {
                        Para para = (Para) objects[cell];
                        if (para != null) {
                            if (!para.empty()) {
                                result =  (K) para.getKey();
                                indexForSearch = cell + 1;
                                break;
                            }
                        }
                    }
                }
                return result;
            }
        };
    }


    public HashMap() {
        this.countCell = 1000;
        this.objects = new Object[countCell];
        this.mapLength = 0;
        this.index = 0;
        this.indexForSearch = 0;
    }
}
