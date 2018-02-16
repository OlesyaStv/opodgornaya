package ru.job4j.application;

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final int EXIT = 6;

    private final Tracker tracker;
    private final Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
//        boolean exit = false;
//        while (!exit) {
//            this.showMenu();
//            String answer = this.input.ask("Введите пункт меню : ");
//            if (ADD.equals(answer)) {
//                this.createItem();
//            } else if (SHOW.equals(answer)) {
//                this.showAll();
//            } else if (EDIT.equals(answer)) {
//                this.edit();
//            } else if (DELETE.equals(answer)) {
//                this.deleteItem();
//            } else if (FINDBYID.equals(answer)) {
//                this.findById();
//            } else if (FINDBYNAME.equals(answer)) {
//                this.findByName();
//            } else if (EXIT.equals(answer)) {
//                exit = true;
//            }
//}
        Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        int key;
        do {
            menuTracker.show();
            ValidateInput vInput = new ValidateInput();
            key =  vInput.ask("Select: ", menuTracker.getRangeOfMenu());
            menuTracker.select(key);
        } while (EXIT != key);


    }

    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println(String.format("------------ Новая заявка с getId : %s-----------", item.getId()));
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        this.tracker.delete(id);
        System.out.println(String.format("------------ Заявка с getId : %s удалена -----------", id));
    }

    private void findById() {
        System.out.println("------------ Поиск заявки по id--------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println(String.format("------------ Найдена заявка с getId : %sname: %s--------------", id, item.getName()));
    }

    private void findByName() {
        System.out.println("------------ Поиск заявки по name--------------");
        String name = this.input.ask("Введите name заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println(String.format("Найдена заявка с getId : %sname: %s", item.getId(), item.getName()));
        }
        System.out.println("------------ Завершился поиск по name--------------");

    }

    private void showAll() {
       System.out.println("------------ Показать все заявки--------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            System.out.println(String.format("Заявка с getId : %s name: %s desc: %s", item.getId(), item.getName(), item.getDesc()));
        }
       System.out.println("------------ Завершился показ всех заявок--------------");

    }

    private void edit() {
        System.out.println("------------Редактирование заявки--------------");
        String idR = this.input.ask("Введите id заявки для редактирования:");
        Item item = this.tracker.findById(idR);
        System.out.println(String.format("Найдена заявка с getId : %sname: %s desc: ",  item.getId(), item.getName(), item.getDesc()));
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item itemNew = new Item(name, desc);
        this.tracker.replace(idR, itemNew);
        System.out.println(String.format("Заявка отредактирована - getId : %sname: %s desc: %s", item.getId(), item.getName(), item.getDesc()));
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

}
