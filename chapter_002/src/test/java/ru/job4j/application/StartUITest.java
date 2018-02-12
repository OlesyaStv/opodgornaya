package ru.job4j.application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteThenTrackerHasAnotherContent() {
        Tracker tracker = new Tracker();
        Item itemF = tracker.add(new Item());
        Item itemS = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", itemF.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getId(), is(itemS.getId()));
    }

    @Test
    public void whenDShawAllItems() {
        Tracker tracker = new Tracker();
        Item itemF = tracker.add(new Item("ferst", "first desc"));
        Item itemS = tracker.add(new Item("second", "second desc"));
        Item itemT = tracker.add(new Item("third", "third desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Показать все заявки--------------")
                                .append(System.lineSeparator())
                                .append("Заявка с getId : " + itemF.getId() + " name: " + itemF.getName() +  " desc: " +  itemF.getDesc())
                                .append(System.lineSeparator())
                                .append("Заявка с getId : " + itemS.getId() + " name: " + itemS.getName() +  " desc: " +  itemS.getDesc())
                                .append(System.lineSeparator())
                                .append("Заявка с getId : " + itemT.getId() + " name: " + itemT.getName() +  " desc: " +  itemT.getDesc())
                                .append(System.lineSeparator())
                                .append("------------ Завершился показ всех заявок--------------")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item itemF = tracker.add(new Item("ferst", "first desc"));
        Item itemS = tracker.add(new Item("second", "second desc"));
        Item itemT = tracker.add(new Item("third", "third desc"));
        Input input = new StubInput(new String[]{"5", "second", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Поиск заявки по name--------------")
                                .append(System.lineSeparator())
                                .append("Найдена заявка с getId : " + itemS.getId() + "name: " + itemS.getName())
                                .append(System.lineSeparator())
                                .append("------------ Завершился поиск по name--------------")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item itemF = tracker.add(new Item("ferst", "first desc"));
        Item itemS = tracker.add(new Item("second", "second desc"));
        Item itemT = tracker.add(new Item("third", "third desc"));
        Input input = new StubInput(new String[]{"4", itemS.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .append("------------ Поиск заявки по id--------------")
                                .append(System.lineSeparator())
                                .append("------------ Найдена заявка с getId : " + itemS.getId() + "name: " + itemS.getName() + "--------------")
                                .append(System.lineSeparator())
                                .append("0. Add new Item")
                                .append(System.lineSeparator())
                                .append("1. Show all items")
                                .append(System.lineSeparator())
                                .append("2. Edit item")
                                .append(System.lineSeparator())
                                .append("3. Delete item")
                                .append(System.lineSeparator())
                                .append("4. Find item by Id")
                                .append(System.lineSeparator())
                                .append("5. Find items by name")
                                .append(System.lineSeparator())
                                .append("6. Exit Program")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
