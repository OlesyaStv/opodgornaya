package ru.job4j.priority;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int taskPr = task.getPriority();
        ListIterator<Task> iterator = tasks.listIterator();
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            while (iterator.hasNext()) {
                Task el = iterator.next();
                if (taskPr < el.getPriority()) {
                    tasks.add(iterator.previousIndex(), task);
                    break;
                }
            }
        }

    }

    public Task take() {
        return this.tasks.poll();
    }
}

