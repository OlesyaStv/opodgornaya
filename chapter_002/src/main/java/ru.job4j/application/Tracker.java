package ru.job4j.application;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null) {
                result[index] = this.items[index];
            }
        }
        return result;
    }

    public void replace(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] == findById(id)) {
                this.items[index] = item;
            }
        }
    }

    public void delete(String id) {
        Item finder = findById(id);
        for (int index = 0; index != this.position; index++) {
            if (items[index] == finder) {
                System.arraycopy(items, index + 1, items, index, items.length - 1 - index);
            }
        }

    }

    public Item[] findByName(String key) {
        Tracker tracker = new Tracker();
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                tracker.add(this.items[index]);
            }
        }
        return tracker.findAll();
    }

}


//
//    public void ipdate(Item item){
//
//    }




