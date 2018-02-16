package ru.job4j.application;

class EditItem implements UserAction {

    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Редактирование заявки--------------");
        String idR = input.ask("Введите id заявки для редактирования:");
        Item item = tracker.findById(idR);
        System.out.println(String.format("Найдена заявка с getId : %sname: %s desc: ",  item.getId(), item.getName(), item.getDesc()));
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        Item itemNew = new Item(name, desc);
        tracker.replace(idR, itemNew);
        System.out.println(String.format("Заявка отредактирована - getId : %sname: %s desc: %s", item.getId(), item.getName(), item.getDesc()));
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}


class FindItemById implements UserAction {

    public int key() {
        return 4;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по id--------------");
        String id = input.ask("Введите id заявки :");
        Item item = tracker.findById(id);
        System.out.println(String.format("------------ Найдена заявка с getId : %sname: %s--------------", id, item.getName()));
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }
}

class Exit implements UserAction {

    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program");
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new MenuTracker.DeleteItems();
        this.actions[4] = new FindItemById();
        this.actions[5] = this.new FindItemByName();
        this.actions[6] = new Exit();
    }

    public int[] getRangeOfMenu() {
        int[] range = new int[actions.length];
        for (int index = 0; index < range.length; index++) {
           range[index] = index;
        }
        return range;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (int index = 0; index < actions.length; index++) {
            if (actions[index] != null) {
                System.out.println(actions[index].info());
            }
        }
    }

    private static class ShowItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Показать все заявки--------------");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("Заявка с getId : %s name: %s desc: %s", item.getId(), item.getName(), item.getDesc()));
            }
            System.out.println("------------ Завершился показ всех заявок--------------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private static class DeleteItems implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            tracker.delete(id);
            System.out.println(String.format("------------ Заявка с getId : %s удалена -----------", id));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    private class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            String.format("------------ Новая заявка с getId : %s-----------", item.getId());
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    private class FindItemByName implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по name--------------");
            String name = input.ask("Введите name заявки :");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println("Найдена заявка с getId : " + item.getId() + "name: " + item.getName());
            }
            System.out.println("------------ Завершился поиск по name--------------");

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
}
