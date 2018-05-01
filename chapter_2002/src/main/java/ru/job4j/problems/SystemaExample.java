package ru.job4j.problems;

public class SystemaExample {

    public Number number;

    public SystemaExample(Number number) {
        this.number = number;
    }

    public static void main(String[] args) {
        Number number = new Number(1);
        SystemaExample system = new SystemaExample(number);
        ThreadExampleInCrease threadFirst = new ThreadExampleInCrease(number);
        ThreadExampleMultiplication threadSecond = new ThreadExampleMultiplication(number);
        System.out.println("Was " + number.getNumber());
        threadFirst.start();
        threadSecond.start();
    }
}
