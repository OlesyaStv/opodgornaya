package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] bufLeft = left.toCharArray();
        char[] bufRight = right.toCharArray();
        int result = 0;
        int index = 0;
        while (index < Math.min(bufLeft.length, bufRight.length)) {
            if (bufLeft[index] > bufRight[index]) {
                result = 1;
                break;
            } else if (bufLeft[index] < bufRight[index]) {
                result = -1;
                break;
            }
            index++;
        }
        if (result == 0) {
            if (bufLeft.length > bufRight.length) {
                result = 1;
            } else if (bufLeft.length < bufRight.length) {
                result = -1;
            }
        }
        return result;
    }
}