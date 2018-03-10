package ru.job4j.user;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Set<User> list = new TreeSet<>();
        list.addAll(users);
        return list;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        Integer o1Length = o1.getName().length();
                        Integer o2Length = o2.getName().length();
                        return o1Length.compareTo(o2Length);
                    }
                }
        );
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        final int rsl = o1.getName().compareTo(o2.getName());
                        return rsl != 0 ? rsl : Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        return users;
    }

}