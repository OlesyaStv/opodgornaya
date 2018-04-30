package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree {

    private Node<E> root;
    private int size;
    private int wasTaken;
    private Node<E> lastTakenElement;

    @Override
    public boolean add(Comparable parent, Comparable child) {
        boolean wasAdded = false;
        Optional<Node> elementFindParent = findBy(parent);
        Optional<Node> elementFindChild = findBy(child);
        if (elementFindParent.isPresent() && !elementFindChild.isPresent()) {
            Node<E> parentFind = (Node<E>) elementFindParent.get();
            parentFind.add(new Node(child));
            wasAdded = true;
            size++;
        }
        return wasAdded;
    }

    public boolean isBinary() {
        boolean isBinary = true;
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                isBinary = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return isBinary;
    }

    @Override
    public Optional<Node> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(((E) value))) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return (Optional) rsl;
    }

    @Override
    public Iterator<E> iterator() {
        lastTakenElement = root;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return wasTaken < size;
            }

            @Override
            public E next() {
                Optional<Node<E>> rsl = Optional.empty();
                Queue<Node<E>> data = new LinkedList<>();
                data.offer(root);
                boolean findNextElement = false;
                while (!data.isEmpty()) {
                    Node<E> el = data.poll();
                    if (findNextElement) {
                        rsl = Optional.of(el);
                        lastTakenElement = rsl.get();
                        break;
                    }
                    if (el.eqValue(((E) lastTakenElement.getValue()))) {
                        findNextElement = true;
                    }
                    for (Node<E> child : el.leaves()) {
                        data.offer(child);
                    }
                }
                return lastTakenElement.getValue();
            }
        };
    }


    public Tree(E root) {
        this.root = new Node(root);
        this.size = 0;
        this.wasTaken = 0;
        this.lastTakenElement = null;
    }
}
