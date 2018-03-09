package ru.job4j.user;

public class User implements Comparable<User> {

    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        final int rsl = o.name.compareTo(this.name);
        return rsl != 0 ? rsl : Integer.compare(o.age, this.age);
    }

}
