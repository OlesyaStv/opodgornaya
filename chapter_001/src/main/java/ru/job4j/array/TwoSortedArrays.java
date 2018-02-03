package ru.job4j.array;

import java.util.Arrays;

public class TwoSortedArrays {

    public int[] backSortFromTwo(int[] arrayFirst, int[] arraySecond) {
        int[] result = new int[arrayFirst.length + arraySecond.length];
        int indexF = 0;
        int indexS = 0;
        for (int indexR = 0; indexR < result.length; indexR++) {
            if (indexF < arrayFirst.length && indexS < arraySecond.length) {
                result[indexR] = (arrayFirst[indexF] <= arraySecond[indexS]) ?  arrayFirst[indexF++] : arraySecond[indexS++];
            }
        }
        if (indexF < arrayFirst.length) {
            System.arraycopy(arrayFirst, indexF, result, indexS + indexF, arrayFirst.length - indexF);
        } else {
            System.arraycopy(arraySecond, indexS, result, indexS + indexF, arraySecond.length - indexS);
        }
        return result;
    }
}
