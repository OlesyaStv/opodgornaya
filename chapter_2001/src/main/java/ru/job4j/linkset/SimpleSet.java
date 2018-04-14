package ru.job4j.linkset;

import ru.job4j.linkedlist.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E>  implements Iterable<E> {

    private Node<E> firstAddElement;
    private Node<E> lastAddElement;
    private Node<E> nodeNext;
    private int index;

    public boolean elementExists(E e) {
        boolean elementIsFind = false;
        Node<E> currentElement = null;
        if (firstAddElement != null) {
            currentElement = firstAddElement;
            if (currentElement.getValue().equals(e)) {
                elementIsFind = true;
            } else {
                while (currentElement.hasNextElement()) {
                    currentElement = currentElement.getNextElement();
                    if (currentElement.getValue().equals(e)) {
                        elementIsFind = true;
                        break;
                    }
                }
            }
        }
        return elementIsFind;
    }

    public int size() {
        return index;
    }

    public void  add(E e) {
        if (!elementExists(e)) {
            Node<E> node = new Node<>(e, index++);
            if (this.lastAddElement != null) {
                lastAddElement.setNextElement(node);
            } else {
                firstAddElement = node;
                nodeNext = node;
            }
            lastAddElement = node;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (nodeNext != null && nodeNext.getIndex() == 0) {
                    hasNext =  true;
                } else {
                    hasNext =  nodeNext.hasNextElement();
                }
                return hasNext;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E returnValue = nodeNext.getValue();
                nodeNext = nodeNext.getNextElement();
                return returnValue;
            }
        };
    }

    public SimpleSet() {
        this.lastAddElement = null;
        this.firstAddElement = null;
        this.index = 0;
    }
}
