package ru.job4j.linkset;

import org.junit.Test;
import ru.job4j.linkedlist.LinkList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    private SimpleSet<Integer> set = new SimpleSet<>();

    @Test
    public void whenAddAndGet() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        assertThat(set.size(), is(3));
    }

    @Test
    public void whenIteratorTestHasNext() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> listIterator = set.iterator();
        assertThat(listIterator.hasNext(), is(true));
    }

    @Test
    public void whenIteratorTestNext() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> listIterator = set.iterator();
        listIterator.next();
        listIterator.next();
        assertThat(listIterator.next(), is(3));
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenIterator() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        Iterator<Integer> listIterator = set.iterator();
        while (listIterator.hasNext()) {
            set.add(7);
        }
    }

}
