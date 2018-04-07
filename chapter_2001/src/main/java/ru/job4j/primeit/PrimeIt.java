package ru.job4j.primeit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIt implements Iterator {

    private int[] values;
    private int index = 0;

    public PrimeIt(int[] values) {
        this.values = values;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        boolean hasN = false;
        for (int ind = index; ind  < values.length; ind++) {
            if (isPrime(this.values[ind])) {
                hasN = true;
                break;
            }
        }
        return hasN;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer ob = null;
        for (int ind = index; ind  < values.length; ind++) {
            if (isPrime(this.values[ind])) {
                ob = this.values[ind];
                index = ind + 1;
                break;
            }
        }
        return ob;
    }
}
