package ru.job4j.phonebook;

import java.util.StringJoiner;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getFullString() {
        StringJoiner str = new StringJoiner(" ");
        str.add(name);
        str.add(surname);
        str.add(phone);
        str.add(address);
        return str.toString();
    }
}