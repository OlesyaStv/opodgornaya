package ru.job4j.tree;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 4);
        tree.add(3, 0);
        assertThat(
                tree.findBy(0).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenGetNext() {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator iterator = tree.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(6));
    }
}
