package ru.job4j.linkedlist;

public class Node<E>  {

    private Node<E>  nextElement;
    private E value;
    private int index;

    public E getValue() {
        return value;
    }

    public Node<E> getNextElement() {
        return nextElement;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean hasNextElement() {
        return this.nextElement != null;
    }

    public void setNextElement(Node<E> nextElement) {
        this.nextElement = nextElement;
    }

    public Node(E value, int index) {
        this.value = value;
        this.nextElement = null;
        this.index = index;
    }

}
