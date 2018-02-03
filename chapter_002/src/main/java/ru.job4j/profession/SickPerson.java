package ru.job4j.profession;

public class SickPerson {

    private String name;
    private String polis;
    private int temperature;

    public SickPerson(String name, String polis, int temperature) {
        this.name = name;
        this.polis = polis;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public String getPolis() {
        return polis;
    }

    public int getTemperature() {
        return temperature;
    }


}
