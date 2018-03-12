package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User user : list) {
            hashMap.put(user.getId(), user);
        }
        return  hashMap;
    }
}
