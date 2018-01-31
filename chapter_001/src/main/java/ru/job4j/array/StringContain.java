package ru.job4j.array;

public class StringContain {

    boolean contains(String origin, String sub) {
        boolean result = false;
        char[] originCharArray = origin.toCharArray();
        char[] subCharArray = sub.toCharArray();

        for (int i = 0; i < originCharArray.length; i++) {
            if (originCharArray[i] == subCharArray [0]) {
                for (int j = 0; j < subCharArray.length; j++) {
                    if ((i + j) < originCharArray.length && originCharArray[i + j] == subCharArray[j]) {
                        result = true;
                    } else {
                        result = false;
                    }
                }
                if (result) {
                    break;
                }

            }
        }
        return result;
    }
}
