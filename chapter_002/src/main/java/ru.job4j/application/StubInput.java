package ru.job4j.application;

public class StubInput implements Input {

    private final String[] value;
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
