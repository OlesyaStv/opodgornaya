package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int height = 0; height < size; height++) {
            for (int width = 0; width < size; width++) {
                array[height][width] = height * width;
            }
        }
        return array;
    }
}
