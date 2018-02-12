package ru.job4j.application;

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();

}
