package ru.job4j.problems;

import java.lang.System;

public class ThreadExampleInCrease extends Thread {

    private Number number;

    @Override
    public void run() {
        increaseNumber();
    }

    public void increaseNumber() {
        this.number.increase();
        System.out.println("ThreadExampleInCrease " + this.number.getNumber());
    }


    ThreadExampleInCrease(Number number) {
        this.number = number;
    }
}
