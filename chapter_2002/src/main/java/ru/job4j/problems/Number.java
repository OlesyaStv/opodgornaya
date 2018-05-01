package ru.job4j.problems;

public class Number {
    private int number;

    public int getNumber() {
        return number;
    }

    public void increase() {
        this.number = this.number + 1;
    }

    Number(int number) {
        this.number = number;
    }
}
