package ru.job4j.user;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenSort() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Nikolay", 28);
        User user2 = new User("Stepan", 10);
        User user3 = new User("Ilya", 28);
        User user4 =  new User("Fedor", 40);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        SortUser sortUser = new SortUser();
        Set<User> sortUsers = sortUser.sort(users);
        Iterator<User> iterator = sortUsers.iterator();
        assertThat(iterator.next(), is(user2));
    }

    @Test
    public void whenSortByNameLength() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Nikolay", 28);
        User user2 = new User("Stepan", 10);
        User user3 = new User("Ilya", 28);
        User user4 =  new User("Fedor", 40);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        SortUser sortUser = new SortUser();
        List<User> sortUsers = sortUser.sortNameLength(users);
        Iterator<User> iterator = sortUsers.iterator();
        assertThat(iterator.next(), is(user3));
    }


    @Test
    public void whenSortByAllFields() {
        List<User> users = new ArrayList<>();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 =  new User("Иван", 25);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        SortUser sortUser = new SortUser();
        List<User> sortUsers = sortUser.sortByAllFields(users);
        Iterator<User> iterator = sortUsers.iterator();
        assertThat(iterator.next(), is(user4));
    }
}
