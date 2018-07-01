package ru.job4j.treadpools;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreadPool {

    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasks;
    private final Integer size = Runtime.getRuntime().availableProcessors();

    public TreadPool() {
        threads = new LinkedList<>();
        tasks = new LinkedBlockingQueue<>();
    }

    public void startThreads() {
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

    public void work(Runnable a) throws InterruptedException {
        tasks.put(a);

    }

    public void shutdown() {
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.isAlive()) {
                t.interrupt();
            }
        }
    }

    public void poll() throws InterruptedException {
        tasks.take();
    }
}
