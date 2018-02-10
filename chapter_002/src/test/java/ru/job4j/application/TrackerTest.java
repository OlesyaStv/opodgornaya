package ru.job4j.application;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test2", "testDescription2", 124L);
        tracker.add(item1);
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item1));
        assertThat(tracker.findAll().length, is(2));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 125L);
        tracker.add(item2);
        item1.setId("7878");
        assertThat(tracker.findById("7878"), is(item1));

    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDel() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 125L);
        tracker.add(item2);
        item.setId("0");
        item1.setId("1");
        item2.setId("2");
        tracker.delete("0");
        assertThat(tracker.findById("0"), is(nullValue()));

    }

    @Test
    public void whenFindElementTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test", "testDescription1", 124L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 125L);
        tracker.add(item2);
        Item[] result = tracker.findByName("test");
        for (Item el : result) {
           assertThat(el.getName(), is("test"));
        }

    }
}
