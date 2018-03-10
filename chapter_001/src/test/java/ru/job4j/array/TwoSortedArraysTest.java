package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoSortedArraysTest {

    @Test
    public void testArrays() {
        TwoSortedArrays twoSortedArrays = new TwoSortedArrays();
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 7, 8, 9, 20};
        int[] arrayRslt = twoSortedArrays.backSortFromTwo(array1, array2);
        int[] arrayShouldBe = {1, 1, 2, 3, 7, 8, 9, 20};
        assertThat(arrayRslt, is(arrayShouldBe));
    }

    @Test
    public void testArraysSameLength() {
        TwoSortedArrays twoSortedArrays = new TwoSortedArrays();
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 7, 8};
        int[] arrayRslt = twoSortedArrays.backSortFromTwo(array1, array2);
        int[] arrayShouldBe = {1, 1, 2, 3, 7, 8};
        assertThat(arrayRslt, is(arrayShouldBe));
    }

}
