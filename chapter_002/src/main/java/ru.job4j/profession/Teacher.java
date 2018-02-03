package ru.job4j.profession;

public class Teacher extends Profession {

    private String subject;

    public Teacher(String name, String surname, String diplom, String subject, int age) {
        super(name, surname, diplom, age);
        subject = subject;
    }

    public void setSubject(String subject)  {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String teach(Student student) {
        String result = getName() + " " + getSurname() + " учит " + student.getName()  + " факультет -  " + student.getFaculty();
        return result;
    }
}
