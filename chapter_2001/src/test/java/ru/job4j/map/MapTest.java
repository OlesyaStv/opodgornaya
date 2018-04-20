package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void whenTestFirst() {
        Map<User, Object> map = new HashMap<>();
        User userFirst = new User("Ivan", 1, new GregorianCalendar(1999, Calendar.DECEMBER, 31));
        User userSecond = new User("Ivan", 1, new GregorianCalendar(1999, Calendar.DECEMBER, 31));
        map.put(userFirst, "userFirst");
        map.put(userSecond, "userSecond");
        System.out.println(map);
    }
}
