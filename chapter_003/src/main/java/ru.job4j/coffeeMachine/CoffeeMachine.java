package ru.job4j.coffeeMachine;

import java.util.ArrayList;

public class CoffeeMachine{

    private static final int[] bills = {1, 2, 5, 10};

    public int[] changes(int value, int price) {
        ArrayList <Integer> list = new ArrayList<>();
        int dif = value - price;
        int ind = bills.length - 1;
        while (dif > 0 && ind >= 0) {
            int kol = (int) Math.floor(dif / bills[ind]);
            while (kol > 0) {
                list.add(bills[ind]);
                dif = dif - bills[ind];
                kol--;
            }
            ind--;
        }
        //Integer[] change = list.toArray(new Integer[list.size()]);
        int[] change = list.stream().mapToInt(i -> i).toArray();
        return change;
    }

}

