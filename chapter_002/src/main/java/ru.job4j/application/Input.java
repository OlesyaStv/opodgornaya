package ru.job4j.application;

public interface Input {

    String ask(String question);

    int ask(String question, int[] range);

}
