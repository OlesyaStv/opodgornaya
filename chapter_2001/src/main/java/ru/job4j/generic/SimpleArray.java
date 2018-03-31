package ru.job4j.generic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleArray <T> implements Iterator{

    Object[] objects;
    int index = 0;

    public SimpleArray(T[] objects) {
        this.objects = objects;
    }

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public T get(int index) {
        return (T) this.objects[index];
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void delete(int finder){
        int changes = 0;
        for (int cell = 0; cell != this.index; cell++) {
            if (cell == finder) {
                changes++;
                if (cell + 1 != this.index) {
                    System.arraycopy(objects, cell + 1, objects, cell, objects.length - 1 - cell);
                } else {
                    objects[cell] = null;
                }
            }
        }
        index = index - changes;
    }

    @Override
    public boolean hasNext() {
        return  index < this.objects.length ? true: false;
    }

    @Override
    public Object next() {
        return objects[index];
    }
}


