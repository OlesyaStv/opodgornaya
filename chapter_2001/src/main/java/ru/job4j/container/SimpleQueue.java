package ru.job4j.container;

public class SimpleQueue<T> extends LinkList {

    public void push(T value) {
        add(value);
    }

    public T poll() {
        T result = null;
        Node<T> currentElement = this.firstAddElement;
        result = currentElement.getValue();
        this.firstAddElement = currentElement.getNextElement();
        this.nodeNext = currentElement.getNextElement();
        this.index--;
        return result;
    }

}
