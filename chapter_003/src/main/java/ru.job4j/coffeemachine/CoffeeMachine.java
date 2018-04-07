package ru.job4j.coffeemachine;

import java.util.ArrayList;

public class CoffeeMachine {

    private static final int[] BILLS = {1, 2, 5, 10};

    public int[] changes(int value, int price) {
        ArrayList<Integer> list = new ArrayList<>();
        int dif = value - price;
        int ind = BILLS.length - 1;
        while (dif > 0 && ind >= 0) {
            int kol = (int) Math.floor(dif / BILLS[ind]);
            while (kol > 0) {
                list.add(BILLS[ind]);
                dif = dif - BILLS[ind];
                kol--;
            }
            ind--;
        }

        int[] change = list.stream().mapToInt(i -> i).toArray();
        return change;
    }

}

