package ru.job4j.storage;

import java.util.Objects;

public class User {
    private int id;
    private int amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
       this.amount = amount;
    }

    public User(Integer id, Integer amount) {
        this.amount = amount;
        this.id = id;
    }
}
