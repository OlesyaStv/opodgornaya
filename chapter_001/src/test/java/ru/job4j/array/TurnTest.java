package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn trn = new Turn();
        int[] massive = new int[] {2, 6, 1, 4};
        int[] arrayrslt = trn.back(massive);
        assertThat(arrayrslt, is(new int[] {4, 1, 6, 2}));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn trn = new Turn();
        int[] massive = new int[] {1, 2, 3, 4, 5};
        int[] arrayrslt = trn.back(massive);
        assertThat(arrayrslt, is(new int[] {5, 4, 3, 2, 1}));
    }
}