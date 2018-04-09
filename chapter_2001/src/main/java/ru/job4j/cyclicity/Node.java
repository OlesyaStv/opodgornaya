package ru.job4j.cyclicity;

public class Node<T>  {
    T value;
    Node<T> next;

    public boolean hasCycle(Node first) {
       boolean hC = false;
       Node<T>[] nodes = new Node[50];
       Node<T> currentElement = first;
       int cell = 0;
       do {
           for (int i = 0; i < nodes.length; i++) {
             if (nodes[i] != null && nodes[i] == currentElement.next) {
                 hC = true;
                 break;
             }
           }
           if (hC) {
               break;
           }
           nodes[cell++] = currentElement;
           currentElement = currentElement.next;
       } while (currentElement.next != null);
       return hC;
    }

    public Node(T element) {
        this.value = element;
    }
}