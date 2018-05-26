package ru.job4j.treadpool;

public class Work {
    private Thread thread;

    public Work(SimpleBlockingQueue<Integer> simpleBlockingQueue) {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
