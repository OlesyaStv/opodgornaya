package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondEquallyFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondMoreThanFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(5, 100, 2);
        assertThat(result, is(100));
    }

    @Test
    public void whenFirstMoreThanSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(100, 5, 2);
        assertThat(result, is(100));
    }

    @Test
    public void whenThirdMoreThanSecondAndFirst() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 100);
        assertThat(result, is(100));
    }
}