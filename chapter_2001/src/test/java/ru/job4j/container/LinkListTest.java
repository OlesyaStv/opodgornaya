package ru.job4j.container;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LinkListTest {

    private LinkList<Integer> list = new LinkList<>();

    @Test
    public void whenAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertThat(list.get(2), is(3));
    }

    @Test
    public void whenRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(0);
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenRemoveInTheMiddle() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        assertThat(list.get(2), is(4));
    }


    @Test
    public void whenIteratorTestHasNext() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> listIterator = list.iterator();
        assertThat(listIterator.hasNext(), is(true));
    }

    @Test
    public void whenIteratorTestNext() {
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
    public void whenIterator() {
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
