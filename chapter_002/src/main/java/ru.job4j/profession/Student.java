package ru.job4j.profession;

public class Student {

    private String name;
    private String university;
    private String faculty;
    private String course;

    public Student(String name, String university, String faculty, String course) {
        this.course = course;
        this.name = name;
        this.faculty = faculty;
        this.course = course;
        this.university = university;
    }

    public String getName() {
        return this.name;
    }

    public String getUniversity() {
        return this.university;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getCourse() {
        return this.course;
    }

}
