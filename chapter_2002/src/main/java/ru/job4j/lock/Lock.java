package ru.job4j.lock;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Lock {

    @GuardedBy("this")
    boolean locked;
    @GuardedBy("this")
    Thread  lockedThread;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (locked && lockedThread != callingThread) {
            System.out.println(String.format("wait %s", Thread.currentThread().getId()));
            wait();
        }
        System.out.println(String.format("lock %s", Thread.currentThread().getId()));
        locked = true;
        lockedThread = callingThread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedThread) {
            locked = false;
            System.out.println(String.format("unlock %s", Thread.currentThread().getId()));
            notify();
        }
    }

    public Lock() {
        this.lockedThread = null;
        this.locked = false;
    }
}