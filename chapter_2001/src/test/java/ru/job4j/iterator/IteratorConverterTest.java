package ru.job4j.iterator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorConverterTest {

    @Test
    public void whenGetNext(){
        int[][]values = {{1, 2}, {3, 4}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.next(), is(4));
    }

    @Test
    public void whenGetNextJA(){
        int[][]values = {{1},{2, 3, 4, 5,},{6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.next(), is(10));
    }

    @Test
    public void whenHasNextTrue(){
        int[][]values = {{1, 2}, {3, 4}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.hasNext(), is(true));
    }

    @Test
    public void whenHasNextFalse(){
        int[][]values = {{1, 2}, {3, 4}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.hasNext(), is(false));
    }

    @Test
    public void whenHasNextJATrue(){
        int[][]values = {{1},{2, 3, 4, 5,},{6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.hasNext(), is(true));
    }

    @Test
    public void whenHasNextJAFalse(){
        int[][]values = {{1},{2, 3, 4, 5,},{6, 7}, {8, 9, 10, 11, 12, 13, 14}};
        IteratorConverter iteratorConverter = new IteratorConverter(values);
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        iteratorConverter.next();
        assertThat(iteratorConverter.hasNext(), is(false));
    }

}