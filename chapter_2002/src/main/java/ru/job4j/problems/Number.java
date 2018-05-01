package ru.job4j.problems;

public class Number {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void increase() {
        this.number = this.number + 100;
    }

    public void multiplication() {
        this.number = this.number * 2;
    }

    Number(int number) {
        this.number = number;
    }
}
