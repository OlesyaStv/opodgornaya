package ru.job4j.dinamiclist;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DinamicListTest {

    private DinamicList<Integer> list;

    @Before
    public void setUp() {
        list = new DinamicList(new Integer[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public synchronized void whenGetNext() {
            Iterator<Integer> listIterator = list.iterator();
            listIterator.next();
            listIterator.next();
            assertThat(listIterator.next(), is(3));
    }

    @Test
    public synchronized void whenAddAndGet() {
            Iterator<Integer> listIterator = list.iterator();
            list.add(8);
            assertThat(list.get(7), is(8));
    }

    @Test
    public synchronized void whenEnlarge() {
            Iterator<Integer> listIterator = list.iterator();
            list.add(8);
            assertThat(list.getRealLength(), is(14));
    }

    @Test(expected = ConcurrentModificationException.class)
    public synchronized void whenIterator() {
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            list.add(777);
        }
    }
}
