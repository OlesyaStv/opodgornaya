package ru.job4j.eveniterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EvenItTest {

    @Test
    public void whenGetNext() {
        int[] values = {4, 1, 1, 2, 1};
        EvenIterator evenIterator = new EvenIterator(values);
        evenIterator.next();
        assertThat(evenIterator.next(), is(2));
    }
}
