package ru.job4j.hashmap;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    private HashMap<Integer, String> map = new HashMap<Integer, String>();

    @Test
    public void whenNoNext() {
        map.insert(1, "Ivanov");
        map.insert(1, "Ivanov");
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenNext() {
        map.insert(1, "Ivanov");
        map.insert(2, "Sidorov");
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
        assertThat(iterator.hasNext(), is(true));
    }


    @Test
    public void whenDelete() {
        map.insert(1, "Ivanov");
        map.insert(2, "Sidorov");
        assertThat(map.delete(2), is(true));
    }

    @Test
    public void whenNoDelete() {
        map.insert(1, "Ivanov");
        map.insert(2, "Sidorov");
        assertThat(map.delete(3), is(false));
    }

    @Test
    public void whenGet() {
        map.insert(1, "Ivanov");
        map.insert(2, "Sidorov");
        assertThat(map.get(2), is("Sidorov"));
    }
}
