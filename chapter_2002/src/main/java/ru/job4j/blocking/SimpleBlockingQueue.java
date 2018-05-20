package ru.job4j.blocking;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    public static final Integer MAXLENGTH = 3;

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            while (queue.size() == MAXLENGTH) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                queue.wait();
            }
            System.out.println(String.format("%s offer %s", Thread.currentThread().getId(), value));
            queue.offer(value);
            queue.notifyAll();
        }
    }

    //должен вернуть объект из внутренней коллекции
    //Если в коллекции объектов нет. то нужно перевести текущую нить в состояние ожидания.
    public T poll() throws InterruptedException {
        synchronized (this.queue) {
            while (queue.isEmpty()) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                queue.wait();
            }

            System.out.println(String.format("%s poll", Thread.currentThread().getId()));
            T elementReturn = queue.poll();
            if (queue.size() < MAXLENGTH) {
                queue.notifyAll();
            }
            return  elementReturn;
        }
    }
}
