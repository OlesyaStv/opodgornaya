package ru.job4j.array;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConvertList {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x: array) {
            for (int y: x) {
                list.add(y);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        if (rows == 0) {
            rows = 1;
        }
        int kolKolonok = 1;
        if (list.size() / rows != list.size()) {
            double del = (double) list.size() / rows;
            kolKolonok = (int) Math.ceil(del);
        }

        int[][] arrayResult = new int[rows][kolKolonok];
        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < kolKolonok; j++) {
                if (iterator.hasNext()) {
                    arrayResult[i][j] = iterator.next();
                }
            }
        }
        return arrayResult;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        ListIterator<int[]> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            for (Integer element: listIterator.next()) {
                result.add(element);
            }
        }
        return result;
    }
}
