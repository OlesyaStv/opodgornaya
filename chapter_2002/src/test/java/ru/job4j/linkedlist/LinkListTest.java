package ru.job4j.linkedlist;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkListTest {

    private LinkList<Integer> list = new LinkList<>();

    @Test
    public synchronized void whenAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertThat(list.get(2), is(3));
    }

    @Test
    public synchronized void whenIteratorTestHasNext() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> listIterator = list.iterator();
        assertThat(listIterator.hasNext(), is(true));
    }

    @Test
    public synchronized void whenIteratorTestNext() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> listIterator = list.iterator();
        listIterator.next();
        listIterator.next();
        assertThat(listIterator.next(), is(3));
    }


    @Test(expected = ConcurrentModificationException.class)
    public synchronized void whenIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            list.add(7);
        }
    }

}
