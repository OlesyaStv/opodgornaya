package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] removeDublicates(String[] array) {
        int uniq = array.length;
        for (int i = 0; i < uniq; i++) {
            for (int j = i + 1; j < uniq; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[uniq - 1];
                    uniq--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, uniq);

    }
}
