package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenAddInteger(){
        SimpleArray array = new SimpleArray(10);
        array.add(122);
        array.add(144);
        array.add(7);
        assertThat(array.get(1), is(144));
    }

    @Test
    public void whenAddString(){
        SimpleArray array = new SimpleArray(10);
        array.add("ggg");
        array.add("test");
        array.add("experiment");
        assertThat(array.get(1), is("test"));
    }

    @Test
    public void whenSetInteger(){
        SimpleArray array = new SimpleArray(10);
        array.add(122);
        array.add(144);
        array.add(7);
        array.set(1, 777);
        assertThat(array.get(1), is(777));
    }

    @Test
    public void whenSetString(){
        SimpleArray array = new SimpleArray(10);
        array.add("ggg");
        array.add("test");
        array.add("experiment");
        array.set(0, "www");
        assertThat(array.get(0), is("www"));
    }

    @Test
    public void whenDeleteString(){
        SimpleArray array = new SimpleArray(10);
        array.add("ggg");
        array.add("test");
        array.add("experiment");
        array.delete(0);
        assertThat(array.get(0), is("test"));
    }

    @Test
    public void whenHasNext(){
        SimpleArray array = new SimpleArray(10);
        array.add("ggg");
        array.add("test");
        array.add("experiment");
        assertThat(array.hasNext(), is(true));
    }

    @Test
    public void whenHaventNext(){
        SimpleArray array = new SimpleArray(3);
        array.add("ggg");
        array.add("test");
        array.add("experiment");
        assertThat(array.hasNext(), is(false));
    }

    @Test
    public void whenNext(){
        String[] sp = {"1", "w", "qq"};
        SimpleArray array = new SimpleArray(sp);
        assertThat(array.next(), is(sp[0]));
    }
}
