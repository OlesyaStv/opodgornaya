package ru.job4j.simpleset;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    private SimpleSet<String> set = new SimpleSet<>(5);

    @Test
    public void whenAddAndGet() {
        set.add("first");
        set.add("second");
        set.add("first");
        set.add("third");
        assertThat(set.size(), is(3));
    }
}
