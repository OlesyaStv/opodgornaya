package ru.job4j.profession;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String diplom, int age) {
        super(name, surname, diplom, age);
    }

    public String construct(House house) {
        String result = getName() + " " + getSurname() + " конструирует дом -"
                + house.getAddress()  + " этажей - " + house.getFloors() + " , квартир - " + house.getAppartments();
        return result;
    }

}
