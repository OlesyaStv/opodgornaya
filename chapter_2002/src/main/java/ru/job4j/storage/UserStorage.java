package ru.job4j.storage;

import java.util.LinkedList;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private LinkedList<User> userStorage;

    public synchronized User findById(Integer id) {
        User result = null;
        for (User currentUser : this.userStorage) {
            if (currentUser != null && currentUser.getId().equals(id)) {
                result = currentUser;
                break;
            }
        }
        return result;
    }

    public synchronized boolean add(User user) {
        boolean wasAdded = false;
        if (findById(user.getId()) == null) {
            userStorage.add(user);
            wasAdded = true;
        }
        return wasAdded;
    }

    public synchronized boolean update(User user) {
        boolean wasUpdate = false;
        int index = userStorage.indexOf(user);
        if (index != -1) {
            userStorage.set(index, user);
            wasUpdate = true;
        }
        return wasUpdate;
    }

    public synchronized boolean delete(User user) {
        boolean wasDeleted = false;
        int index = userStorage.indexOf(user);
        if (index != -1) {
            userStorage.remove(index);
            wasDeleted = true;
        }
        return wasDeleted;
    }

    public synchronized void  transfer(int fromId, int toId, int amount) {
      User userFrom = findById(fromId);
      User userTo = findById(toId);
      if (userFrom != null && userTo != null && userFrom.getAmount() >= amount) {
          userFrom.setAmount(userFrom.getAmount() - amount);
          userTo.setAmount(userTo.getAmount() + amount);
      }
    }

    public UserStorage() {
        userStorage = new LinkedList<>();
    }

    public synchronized int getSize() {
        return userStorage.size();
    }
}
