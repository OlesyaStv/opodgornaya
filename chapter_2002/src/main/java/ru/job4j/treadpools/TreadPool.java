package ru.job4j.treadpools;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@ThreadSafe
public class TreadPool {

    private final List<Thread> threads;
    @GuardedBy("tasks")
    private final Queue<Runnable> tasks;
    private final Integer size = Runtime.getRuntime().availableProcessors();

    public void work(Runnable a) throws InterruptedException {
        synchronized (this.tasks) {
            while (tasks.size() == size) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                tasks.wait();
            }
            System.out.println(String.format("%s offer ", Thread.currentThread().getId()));
            tasks.offer(a);
            tasks.notifyAll();
        }
    }

      public void shutdown() {

    }

    public void poll() throws InterruptedException {
        synchronized (this.tasks) {
            while (tasks.isEmpty()) {
                System.out.println(String.format("%s wait", Thread.currentThread().getId()));
                tasks.wait();
            }
            tasks.poll();
            System.out.println(String.format("%s poll", Thread.currentThread().getId()));
            if (tasks.size() < size) {
                tasks.notifyAll();
            }
        }
    }

    public TreadPool() {
        threads = new LinkedList<>();
        tasks = new LinkedBlockingQueue<>();
        for (int j = 0; j < size; j++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        poll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threads.add(thread);
            thread.start();
        }
    }

    public Integer getSize() {
        return this.size;
    }
}
