package ru.job4j.array;

import jdk.nashorn.internal.ir.IfNode;

public class Turn {

    public int[] back(int[] array) {

        for (int i = 0; i < (array.length / 2); i++) {
            int vsp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = vsp;
        }
        return  array;

    }
}
