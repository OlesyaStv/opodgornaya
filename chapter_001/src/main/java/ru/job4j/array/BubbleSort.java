package ru.job4j.array;

public class BubbleSort {

    public int[] backSort(int[] array) {
        boolean change;
        do {
            change = false;
            for (int i = 0; i < array.length; i++) {
                if ((i + 1) < array.length && array[i] > array[i + 1]) {
                    int vsp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = vsp;
                    change = true;
                }
            }
        }
        while (change);
        return array;

    }

}
