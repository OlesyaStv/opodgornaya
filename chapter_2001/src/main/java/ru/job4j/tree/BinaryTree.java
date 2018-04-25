package ru.job4j.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> implements SimpleTree {

    private BSTNode<E> root;
    private int size;
    private int wasTaken;
    private BSTNode<E> takenElement;

    @Override
    public boolean add(Comparable parent, Comparable child) {
        boolean wasAdded = false;
        Optional<BSTNode> elementParent = findBy(parent);
        if (elementParent != null) {
            BSTNode<E> parentFind = (BSTNode<E>) elementParent.get();
            BSTNode<E> childFind = new BSTNode<E>((E) child);
            parentFind.add(childFind);
            size++;
            wasAdded = true;
        }
        return wasAdded;
    }

    private Queue<BSTNode<E>> addBuffer(Queue<BSTNode<E>> data, BSTNode<E> el) {
        if (el.getLeftChild() != null && el.getRigthChild() != null) {
            data.offer(el.getLeftChild());
            data.offer(el.getRigthChild());
        } else if (el.getLeftChild() != null) {
            data.offer(el.getLeftChild());
        } else if (el.getRigthChild() != null) {
            data.offer(el.getRigthChild());
        }
        return data;
    }

    @Override
    public Optional<BSTNode> findBy(Comparable value) {
        boolean wasFind = false;
        Queue<BSTNode<E>> data = new LinkedList<>();
        Optional<BSTNode<E>> rsl = Optional.empty();
        data.offer(this.root);
        while (!wasFind && !data.isEmpty()) {
            BSTNode<E> el = data.poll();
            if (el.compare(((E) value)) == 0) {
                rsl = Optional.of(el);
                wasFind = true;
            }
            addBuffer(data, el);
        }
        return (Optional) rsl;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return wasTaken < size;
            }

            @Override
            public E next() {
                if (takenElement == null) {
                    takenElement = root;
                } else {
                    boolean findNextElement = false;
                    Optional<BSTNode<E>> rsl = Optional.empty();
                    Queue<BSTNode<E>> data = new LinkedList<>();
                    data.offer(root);
                    while (!data.isEmpty()) {
                        BSTNode<E> el = data.poll();
                        if (findNextElement) {
                            rsl = Optional.of(el);
                            takenElement = rsl.get();
                            break;
                        }
                        if (el.eqValue(((E) takenElement.getValue()))) {
                            findNextElement = true;
                        }
                        addBuffer(data, el);
                    }
                }
                return takenElement.getValue();
            }
        };
    }

    public BinaryTree(E root) {
        this.root = new BSTNode(root);
        this.size = 0;
        this.wasTaken = 0;
        this.takenElement = null;

    }
}
