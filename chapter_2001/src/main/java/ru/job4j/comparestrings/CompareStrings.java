package ru.job4j.comparestrings;

import java.util.*;

public class CompareStrings {

    private String firstString;
    private String secondString;
    HashMap<Character, Integer> hashMapF;
    HashMap<Character, Integer> hashMapS;
    private boolean identical;

    private Integer numberInLine(Character character, String line) {
       int numberInLine = 0;
       char[] lineArray = line.toCharArray();
       for (char symbol = 0; symbol < lineArray.length; symbol++) {
           if (character == lineArray[symbol]) {
               numberInLine++;
           }
       }
       return numberInLine;
    }

    public boolean identical() {
        boolean identical = false;
        Set uniqueSymbolsF = new LinkedHashSet();
        Set uniqueSymbolsS = new LinkedHashSet();
        char[] firstStringArray = firstString.toCharArray();
        char[] secondStringArray = secondString.toCharArray();
        if (firstString.length() == secondString.length()) {
            for (char symbol = 0; symbol < firstStringArray.length; symbol++) {
                uniqueSymbolsF.add(firstStringArray[symbol]);
                uniqueSymbolsS.add(secondStringArray[symbol]);
            }
            if (uniqueSymbolsF.size() == uniqueSymbolsS.size()) {
                Iterator iteratorF = uniqueSymbolsF.iterator();
                while (iteratorF.hasNext()) {
                    Character symbolF = (Character) iteratorF.next();
                    hashMapF.put(symbolF, numberInLine(symbolF, firstString));
                }
                Iterator iteratorS = uniqueSymbolsS.iterator();
                while (iteratorS.hasNext()) {
                    Character symbolS = (Character) iteratorS.next();
                    hashMapS.put(symbolS, numberInLine(symbolS, secondString));
                }
                if (hashMapF.equals(hashMapS)) {
                    identical = true;
                }
            }
        }
        return identical;
    }


    public CompareStrings(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.hashMapF = new HashMap<Character, Integer>();
        this.hashMapS = new HashMap<Character, Integer>();
        this.identical = identical();
    }

    public boolean getIdentical() {
        return identical;
    }
}
