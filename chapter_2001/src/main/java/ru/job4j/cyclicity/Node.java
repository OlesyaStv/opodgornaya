package ru.job4j.cyclicity;

public class Node<T>  {
    T value;
    Node<T> next;

    public boolean hasCycle(Node first) {
       boolean hasCycle = false;
       Node<T>[] nodes = new Node[50];
       Node<T> currentElement = first;
       int cell = 0;
       do {
           for (int i = 0; i < nodes.length; i++) {
             if (nodes[i] != null && nodes[i] == currentElement.next) {
                 hasCycle = true;
                 break;
             }
           }
           if (hasCycle) {
               break;
           }
           nodes[cell++] = currentElement;
           currentElement = currentElement.next;
       } while (currentElement.next != null);
       return hasCycle;
    }

    public boolean hasCycleHareTurtle(Node first) {
        boolean hasCycle = false;
        Node<T> turtle = first;
        Node<T> hare = first;
        while (!hasCycle && hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                hasCycle = true;
            }
        }
        return hasCycle;
    }

    public Node(T element) {
        this.value = element;
    }
}