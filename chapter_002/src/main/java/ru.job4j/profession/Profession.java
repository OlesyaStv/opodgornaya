package ru.job4j.profession;

public class Profession {
    private String name;
    private String surname;
    private int age;
    private String diplom;

    public Profession(String name, String surname, String diplom, int age) {
        this.diplom  = diplom;
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
}

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
    public String getDiplom() {
        return diplom;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setDiplom(String diplom) {
        this.diplom  = diplom;
    }
}
