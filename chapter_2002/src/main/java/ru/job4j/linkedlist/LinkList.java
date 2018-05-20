package ru.job4j.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class LinkList<E> implements Iterable {

    @GuardedBy("this")
    private Node<E> lastAddElement;
    @GuardedBy("this")
    private Node<E> firstAddElement;
    @GuardedBy("this")
    private Node<E> node;
    @GuardedBy("this")
    private Node<E> nodeNext;
    @GuardedBy("this")
    private int modCount;
    @GuardedBy("this")
    private int index;

    public synchronized void  add(E value) {
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

    public synchronized E get(int index) {
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
