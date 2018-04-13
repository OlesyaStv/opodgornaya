package ru.job4j.container;

public class SimpleQueue<T> extends LinkList<T> {

    public void push(T value) {
        add(value);
    }

    public T poll() {
        Node<T> currentElement = this.firstAddElement;
        remove(currentElement.getIndex());
        return currentElement.getValue();
    }

}
