package ru.job4j.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkList<E> implements Iterable {

    private Node<E> lastAddElement;
    private Node<E> firstAddElement;
    private Node<E> node;
    private Node<E> nodeNext;
    private int modCount;
    private int index;

    public void  add(E value) {
        modCount++;
        this.node = new Node<>(value, index++);
        if (this.lastAddElement != null) {
            lastAddElement.setNextElement(node);
        } else {
            firstAddElement = node;
            nodeNext = node;
        }
        lastAddElement = node;
    }

    public E get(int index) {
        E element = null;
        Node<E> currentElement = firstAddElement;
        do {
            if (currentElement.getIndex() == index) {
                element = currentElement.getValue();
                break;
            } else {
                currentElement = currentElement.getNextElement();
            }
        } while (currentElement != null);

        return element;
    }

    @Override
    public Iterator iterator() {

        int expectedModCount = modCount;

        return new Iterator<E>() {

            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean hN = false;
                if (nodeNext != null && nodeNext.getIndex() == 0) {
                    hN =  true;
                } else {
                    hN =  nodeNext.hasNextElement();
                }
                return hN;

            }

            @Override
            public E next() throws ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E returnValue = nodeNext.getValue();
                nodeNext = nodeNext.getNextElement();
                return returnValue;
            }
        };
    }

    public LinkList() {
        this.lastAddElement = null;
        this.firstAddElement = null;
        this.modCount = 0;
        this.index = 0;
        this.nodeNext = null;
    }
}
