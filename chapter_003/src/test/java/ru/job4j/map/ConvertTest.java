package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertTest {
    @Test
    public void whenProcess() {
        UserConvert us = new UserConvert();
        List<User> listOfUsers = new ArrayList<>();
        User checkUser = new User("id3", "Sidorov", "Permian");
        listOfUsers.add(new User("id1", "Ivanov", "St. Petersburg"));
        listOfUsers.add(new User("id2", "Petrov", "Moscow"));
        listOfUsers.add(checkUser);
        listOfUsers.add(new User("id4", "Fedorov", "Tula"));
        listOfUsers.add(new User("id5", "Gruzov", "Stavropol"));
        HashMap<Integer, User> map = us.process(listOfUsers);
        assertThat(map.get(2), is(checkUser));
    }

}
