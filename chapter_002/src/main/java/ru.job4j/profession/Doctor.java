package ru.job4j.profession;

public class Doctor extends Profession {

    private String dissertation;

    public Doctor(String name, String surname, String diplom, String dissertation, int age) {
       super(name, surname, diplom, age);
       dissertation = dissertation;
    }

    public void setDissertation(String dissertation) {
        this.dissertation = dissertation;
    }

    public String getDissertation() {
        return dissertation;
    }

    public String treat(SickPerson sickPerson) {
       String result = getName() + " " + getSurname() + " лечит " + sickPerson.getName()
               + " полис -  " + sickPerson.getPolis() + " температура " + sickPerson.getTemperature();
       return result;
    }
}
