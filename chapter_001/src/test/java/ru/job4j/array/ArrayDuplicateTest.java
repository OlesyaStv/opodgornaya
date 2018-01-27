package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;


public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDublicates() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] massive = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDuplicate.removeDublicates(massive);
        String[] needResive = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(needResive));
    }

    @Test
    public void whenRemoveDublicatesSecond() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] massive = new String[] {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] result = arrayDuplicate.removeDublicates(massive);
        String[] needResive = new String[] {"Привет"};
        assertThat(result, arrayContainingInAnyOrder(needResive));
    }
}
