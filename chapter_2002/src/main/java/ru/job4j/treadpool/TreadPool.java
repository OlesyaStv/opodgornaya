package ru.job4j.treadpool;

import java.util.LinkedList;

public class TreadPool {

    private LinkedList<Work> threads;
    private SimpleBlockingQueue<Integer> simpleBlockingQueue;

    public TreadPool() {
        threads = new LinkedList<>();
        simpleBlockingQueue = new SimpleBlockingQueue<>();
    }

    public void add(Work work) {
        threads.add(work);
    }

    public void offer(Integer integer) throws InterruptedException {
        Thread offerTread = new Thread() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        offerTread.start();
    }

    public SimpleBlockingQueue<Integer> getSimpleBlockingQueue() {
        return this.simpleBlockingQueue;
    }
}
