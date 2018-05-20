package ru.job4j.blocking;

public class SimpleBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        final SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<Integer>();

        Thread consumer = new Thread() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread producer = new Thread() {
            @Override
            public void run() {
                try {
                    simpleBlockingQueue.offer(1);
                    simpleBlockingQueue.offer(2);
                    simpleBlockingQueue.offer(3);
                    simpleBlockingQueue.offer(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        consumer.start();
        producer.start();
        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
