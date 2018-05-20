package ru.job4j.threads;

public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new ThreadPool();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.add(new Work("process1", 700));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.add(new Work("process2", 6000000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.add(new Work("process3", 700));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.add(new Work("process4", 800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread4.start();
        try {
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread5 = new Thread() {
            @Override
            public void run() {
                try {
                    threadPool.add(new Work("process5", 900));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread5.start();
        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
