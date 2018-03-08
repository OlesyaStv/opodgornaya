package ru.job4j.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Random;

public class Tracker {

    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item findById(String id) {
        Item result = null;
        ListIterator<Item> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            Item item = listIterator.next();
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        return this.items;
    }

    public void replace(String id, Item item) {
        ListIterator<Item> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            Item el = listIterator.next();
            if (el.equals(findById(id))) {
                id = el.getId();
                item.setId(id);
                listIterator.set(item);
            }
        }
    }

    public void delete(String id) {
        this.items.remove(findById(id));
    }


    public ArrayList<Item> findByName(String key) {
        Tracker tracker = new Tracker();
        ListIterator<Item> listIterator = items.listIterator();
        while (listIterator.hasNext()) {
            Item el = listIterator.next();
            if (el.getName().equals(key)) {
                tracker.add(el);
            }
        }
        return tracker.findAll();
    }

}





