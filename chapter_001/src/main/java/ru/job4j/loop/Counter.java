package ru.job4j.loop;

/**
 * Class �����������
 * @author opodgornaya
 * @since 24.01.2018
 * @version 1
 */

public class Counter {
    public int add(int start, int finish) {
        int result = 0;
        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                result = result + index;
            }

        }
        return result;
    }
}
