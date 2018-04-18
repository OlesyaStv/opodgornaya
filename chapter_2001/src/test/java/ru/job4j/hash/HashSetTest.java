package ru.job4j.hash;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HashSetTest {

    private HashSet<Integer> set = new HashSet<>(1000);

    @Test
    public void whenAdd() {
        assertThat(set.add(1), is(true));
    }

    @Test
    public void whenContains() {
       int element = 1;
       set.add(element);
       assertThat(set.contains(element), is(true));
    }

    @Test
    public void whenNotContains() {
        int element = 1;
        set.add(element);
        assertThat(set.contains(2), is(false));
    }

    @Test
    public void whenRemove() {
        int element = 1;
        set.add(element);
        assertThat(set.remove(element), is(true));
    }

}
