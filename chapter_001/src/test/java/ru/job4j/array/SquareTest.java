package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void whenBoundFour() {
        Square sq = new Square();
        int[] rst = sq.calculate(4);
        int[] expected = new int[] {0, 1, 4, 9};
        assertThat(rst, is(expected));

    }

}
