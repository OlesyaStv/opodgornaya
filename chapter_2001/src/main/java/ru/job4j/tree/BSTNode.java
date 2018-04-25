package ru.job4j.tree;

public class BSTNode<E extends Comparable<E>> {

    private final E value;
    private BSTNode<E> leftChild;
    private BSTNode<E> rigthChild;

    public BSTNode(final E value) {
        this.value = value;
    }

    public void add(BSTNode<E> child) {
        if (this.value.compareTo(child.value) < 0) {
            this.leftChild = child;
        } else {
            this.rigthChild = child;
        }
    }

    public BSTNode<E> getLeftChild() {
        return this.leftChild;
    }

    public BSTNode<E> getRigthChild() {
        return this.rigthChild;
    }

    public E getValue() {
        return value;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

    public int compare(E that) {
        return this.value.compareTo(that);
    }
}

