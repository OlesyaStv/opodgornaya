package ru.job4j.comparestrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class CompareStrings {

    private String firstString;
    private String secondString;
    HashMap<Character, Integer> hashMap;
    private boolean identical;

    public boolean identical() {
        boolean identical = false;
        Set uniqueSymbolsF = new LinkedHashSet();
        char[] firstStringArray = firstString.toCharArray();
        char[] secondStringArray = secondString.toCharArray();
        for (int symbol = 0; symbol < firstStringArray.length; symbol++) {
            uniqueSymbolsF.add(firstStringArray[symbol]);
            if (hashMap.get(firstStringArray[symbol]) == null) {
                hashMap.put(firstStringArray[symbol], 0);
            }
            hashMap.put(firstStringArray[symbol], hashMap.get(firstStringArray[symbol]) + 1);
        }

        for (int i = 0; i < secondStringArray.length; i++) {
            Integer amount = hashMap.get(secondStringArray[i]);
            amount = amount == null ? 0 : amount - 1;
            if (amount < 0) {
                identical = false;
                break;
            } else {
                identical = true;
                hashMap.put(secondStringArray[i], amount);
            }
        }
        return identical;
    }

    public CompareStrings(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.hashMap = new HashMap<Character, Integer>();
        this.identical = identical();
    }

}
