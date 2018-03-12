package ru.job4j.map;

public class User {

    private Integer id;
    private String name;
    private String city;

    public User(Integer id, String name, String city) {

        this.id = id;
        this.city = city;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
        this.id = id;
    }
}
