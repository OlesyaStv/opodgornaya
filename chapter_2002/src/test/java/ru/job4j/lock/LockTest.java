package ru.job4j.lock;

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        lock.lock();
        lock.unlock();
    }
}
