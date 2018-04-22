package ru.job4j.hashmap;

import java.util.Objects;

public class Para<K, V>  {

    private K key;
    private V value;
    private boolean empty;

    public Para(K key, V value) {
        this.key = key;
        this.value = value;
        this.empty = false;
    }

    public V getValue() {
        V result = null;
        if (!empty) {
            result = this.value;
        }
        return value;
    }

    public K getKey() {
        return key;
    }

    public void  delete() {
        this.empty = true;
    }

    public boolean empty() {
        return empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Para<?, ?> para = (Para<?, ?>) o;
        return Objects.equals(key, para.key) && Objects.equals(value, para.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
