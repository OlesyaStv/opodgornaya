package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterator {

    Object[] objects;
    int index = 0;

    public SimpleArray(T[] objects) {
        this.objects = objects;
    }

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public int size() {
        return index;
    }

    public int getIndex() {
        return index;
    }

    public void  resetIndexForTest() {
        index = 0;
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

    public void delete(int finder) {
        int cell = Arrays.asList(objects).indexOf(objects[finder]);
        System.arraycopy(objects, cell + 1, objects, cell, objects.length - 1 - cell);
        index = index - 1;
    }

    @Override
    public boolean hasNext() {
        return  index < this.objects.length ? true : false;
    }

    @Override
    public Object next() {
        return objects[index++];
    }
}


