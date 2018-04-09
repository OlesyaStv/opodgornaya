package ru.job4j.container;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> list = new SimpleQueue<>();

    @Test
    public void whenPushAndPoll() {
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        assertThat(list.poll(), is(1));
    }
}
