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
        List<Integer> listCopy = new ArrayList<Integer>(list);
        int lisrSize = list.size();
        int kolNull = rows - (int) lisrSize % rows;
        for (int index = 0; index < kolNull; index++) {
            listCopy.add(0);
        }
        lisrSize = listCopy.size();
        int kolKolonok = lisrSize / rows;
        int[][] arrayResult = new int[rows][kolKolonok];
        ListIterator<Integer> iterator = listCopy.listIterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < kolKolonok; j++) {
                    arrayResult[i][j] = iterator.next();
                }
            }
        }
        return arrayResult;
    }
}
