package ru.job4j.linkedlist;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Node<E>  {
    @GuardedBy("this")
    private Node<E>  nextElement;
    @GuardedBy("this")
    private E value;
    @GuardedBy("this")
    private int index;

    public synchronized E getValue() {
        return value;
    }

    public synchronized Node<E> getNextElement() {
        return nextElement;
    }

    public synchronized int getIndex() {
        return this.index;
    }

    public synchronized boolean hasNextElement() {
        return this.nextElement != null;
    }

    public synchronized void setNextElement(Node<E> nextElement) {
        this.nextElement = nextElement;
    }

    public Node(E value, int index) {
        this.value = value;
        this.nextElement = null;
        this.index = index;
    }

}
