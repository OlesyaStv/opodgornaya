package ru.job4j.storage;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class UserStorageTest {

    private UserStorage userStorage = new UserStorage();

    @Test
    public void whenTransfer() {
        User userFrom = new User(1, 1000);
        User userTo = new User(2, 0);
        userStorage.add(userFrom);
        userStorage.add(userTo);
        userStorage.transfer(1, 2, 500);
        assertThat(userFrom.getAmount(), is(500));
    }

    @Test
    public void whenAdd() {
        User userFrom = new User(1, 1000);
        User userTo = new User(2, 0);
        userStorage.add(userFrom);
        userStorage.add(userTo);
        assertThat(userStorage.getSize(), is(2));
    }

    @Test
    public void whenDelete() {
        User userFrom = new User(1, 1000);
        User userTo = new User(2, 0);
        userStorage.add(userFrom);
        userStorage.add(userTo);
        userStorage.delete(userFrom);
        assertThat(userStorage.getSize(), is(1));
    }

    @Test
    public void whenUpdate() {
        User userFrom = new User(1, 1000);
        User userTo = new User(2, 0);
        userStorage.add(userFrom);
        userStorage.add(userTo);
        User userUpdate = new User(1, 530);
        userStorage.update(userUpdate);
        assertThat(userStorage.findById(1).getAmount(), is(530));
    }
}
