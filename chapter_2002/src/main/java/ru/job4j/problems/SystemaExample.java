package ru.job4j.problems;

public class SystemaExample {

    public static void main(String[] args) {
        Number number = new Number(1);
        ThreadExampleInCrease threadFirst = new ThreadExampleInCrease(number);
        ThreadExampleInCrease threadSecond = new ThreadExampleInCrease(number);
        System.out.println("Was " + number.getNumber());
        threadFirst.start();
        threadSecond.start();
    }
}
