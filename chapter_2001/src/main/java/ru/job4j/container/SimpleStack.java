package ru.job4j.container;

public class SimpleStack<T> extends LinkList<T> {
    public void push(T value) {
        add(value);
    }

    public T poll() {
        Node<T> currentElement = this.lastAddElement;
        remove(currentElement.getIndex());
        return currentElement.getValue();
    }
}