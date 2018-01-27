package ru.job4j.array;

import jdk.nashorn.internal.ir.IfNode;

public class Turn {

    public int[] back(int[] array) {
        int ln = array.length;
        int doElementa = (ln / 2);
        if (ln % 2 != 0) {
            doElementa = (ln - 1) / 2;
        }

        int z = 1;
        for (int i = 0; i < doElementa; i++) {
            int vsp = array[i];
            array[i] = array[ln - z];
            array[ln - z] = vsp;
            z += 1;
        }

        return  array;

    }
}
