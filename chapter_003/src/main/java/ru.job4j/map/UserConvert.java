package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        ListIterator<User> listIterator = list.listIterator();
        Integer key = 0;
        while (listIterator.hasNext()) {
            hashMap.put(key, listIterator.next());
            key++;
        }

        return  hashMap;

    }
}
