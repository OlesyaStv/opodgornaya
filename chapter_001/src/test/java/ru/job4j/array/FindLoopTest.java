package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenFind() {
        FindLoop fl = new FindLoop();
        int[] massive = new int[] {0, 1, 4, 9};
        int rst = fl.indexOf(massive, 4);
        assertThat(rst, is(2));

    }


    @Test
    public void whenProblem() {
        FindLoop fl = new FindLoop();
        int[] massive = new int[] {0, 1, 4, 9};
        int rst = fl.indexOf(massive, 7);
        assertThat(rst, is(-1));

    }
}
