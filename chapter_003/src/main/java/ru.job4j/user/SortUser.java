package ru.job4j.user;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Set<User> list = new TreeSet<>();
        list.addAll(users);
        return list;
    }

}