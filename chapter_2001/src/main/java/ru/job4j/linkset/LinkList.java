package ru.job4j.linkset;

import ru.job4j.linkedlist.Node;

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

    public int getModCount() {
        return modCount;
    }

    public boolean contains(E e) {
        boolean elementIsFind = false;
        Node<E> currentElement = null;
        if (firstAddElement != null) {
            currentElement = firstAddElement;
            if (currentElement.getValue().equals(e)) {
                elementIsFind = true;
            } else {
                while (!elementIsFind && currentElement.hasNextElement()) {
                    currentElement = currentElement.getNextElement();
                    if (currentElement.getValue().equals(e)) {
                        elementIsFind = true;
                    }
                }
            }
        }
        return elementIsFind;
    }

    public int size() {
        return index;
    }

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
                boolean hasNext = false;
                if (nodeNext != null && nodeNext.getIndex() == 0) {
                    hasNext =  true;
                } else {
                    hasNext =  nodeNext.hasNextElement();
                }
                return hasNext;
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
