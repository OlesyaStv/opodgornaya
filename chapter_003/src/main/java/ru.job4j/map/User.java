package ru.job4j.map;

public class User {

    private String id;
    private String name;
    private String city;

    public User(String id, String name, String city) {

        this.id = id;
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
