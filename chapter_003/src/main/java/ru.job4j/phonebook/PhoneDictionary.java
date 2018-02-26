package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        ListIterator<Person> iterator = persons.listIterator();
        while (iterator.hasNext()) {
            Person human = iterator.next();
            String fullString = human.getFullString();
            if (fullString.contains(key)) {
                result.add(human);
            }
        }
        return result;
    }
}