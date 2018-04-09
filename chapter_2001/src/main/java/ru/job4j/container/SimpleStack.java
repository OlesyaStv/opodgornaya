package ru.job4j.container;

public class SimpleStack<T> extends LinkList {
    public void push(T value) {
        add(value);
    }

    public T poll() {
        T result = null;
        Node<T> currentElement = this.lastAddElement;
        result = currentElement.getValue();
        this.lastAddElement = currentElement.getNextElement();
        this.index--;
        return result;
    }
}