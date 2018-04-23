package ru.job4j.hash;

public class PairEntry<E> {
    private int key;
    private E value;
    private boolean empty;

    public boolean getEmpty() {
       return this.empty;
    }

    public void setEmpty() {
        this.empty = true;
    }

    public E getValue() {
        return value;
    }

    public PairEntry(int key, E value) {
        this.key = key;
        this.value = value;
        this.empty = false;
    }
}
