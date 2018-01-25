package ru.job4j.loop;

/**
 * Class
 * @author opodgornaya
 * @since 24.01.2018
 * @version 1
 */

public class Factorial {

    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;

    }
}
