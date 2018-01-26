package ru.job4j.array;

public class Square {

    public int[] calculate(int bound) {

        int[] rst = new int[bound];
        for (int i = 0; i <  bound; i++) {
            int z = i + 1;
            rst[i] = z * z;
        }
        return rst;

    }
}
