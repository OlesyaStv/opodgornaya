package ru.job4j.problems;

public class ThreadExampleMultiplication extends Thread {

    private Number number;

    @Override
    public void run() {
        multiplicationNumber();
    }


    public void multiplicationNumber() {
        this.number.multiplication();
        System.out.println("ThreadExampleMultiplication " + this.number.getNumber());
    }

    ThreadExampleMultiplication(Number number) {
        this.number = number;
    }
}
