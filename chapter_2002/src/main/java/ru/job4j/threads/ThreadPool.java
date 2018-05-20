package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Timer;

@ThreadSafe
public class ThreadPool {

    @GuardedBy("this")
    private LinkedList<Work> threads = new LinkedList<>();
    public static final Integer CORES = Runtime.getRuntime().availableProcessors();
    private Timer timer = new Timer();

    public void doingSomething(Work work) throws InterruptedException {
        synchronized (this.threads) {
            System.out.println(String.format("doingSomething %s %s", Thread.currentThread().getId(), work.getName()));
            int time = work.getWorkTime();
            while (time > 0) {
                time--;
            }
            threads.remove(work);
            threads.notifyAll();
        }
    }

    public void add(Work work) throws InterruptedException {
        synchronized (this.threads) {
            while (threads.size() >= CORES) {
                System.out.println(String.format("%s  %s wait", Thread.currentThread().getId(), work.getName()));
                threads.wait();
            }
        }
        System.out.println(String.format("%s %s add", Thread.currentThread().getId(), work.getName()));
        threads.add(work);
        doingSomething(work);
    }

}
