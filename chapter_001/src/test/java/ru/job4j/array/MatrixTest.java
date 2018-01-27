package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MatrixTest {

    @Test
    public void testArray() {
        Matrix matrix = new Matrix();
        int[][] arrayrslt = matrix.multiple(3);
        int[][] massive = {{0, 0, 0}, {0, 1, 2}, {0, 2, 4}};
        assertThat(arrayrslt, is(massive));
    }
}
