package ru.job4j.array;

public class TwoSortedArrays {

    public int[] backSortFromTwo(int[] arrayFirst, int[] arraySecond) {
        int[] result = new int[arrayFirst.length + arraySecond.length];
        int indexF = 0;
        int indexS = 0;
        for (int indexR = 0; indexR < result.length; indexR++) {
            if (indexF < arrayFirst.length && indexS < arraySecond.length) {
                if (arrayFirst[indexF] <= arraySecond[indexS]) {
                    result[indexR] = arrayFirst[indexF];
                    indexF += 1;
                } else {
                    result[indexR] = arraySecond[indexS];
                    indexS += 1;
                }
            } else if (indexF < arrayFirst.length) {
                result[indexR] = arrayFirst[indexF];
                indexF += 1;

            } else if (indexS < arraySecond.length) {
                result[indexR] = arraySecond[indexS];
                indexS += 1;
            }
        }
        return result;
    }
}
