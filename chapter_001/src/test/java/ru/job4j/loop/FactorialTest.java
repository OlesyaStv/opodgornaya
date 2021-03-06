package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void whenCheckFactorial5() {
        Factorial f = new Factorial();
        int result = f .calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenCheckFactorial0() {
        Factorial f = new Factorial();
        int result = f .calc(0);
        assertThat(result, is(1));
    }
}
