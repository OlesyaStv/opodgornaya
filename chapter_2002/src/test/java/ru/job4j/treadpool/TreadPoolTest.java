package ru.job4j.treadpool;

import org.junit.Test;

public class TreadPoolTest {

    @Test
    public void whenTest() throws InterruptedException {
        TreadPool treadPool = new TreadPool();
        for (int i = 0; i < treadPool.getSimpleBlockingQueue().getMCore(); i++) {
            treadPool.add(new Work(treadPool.getSimpleBlockingQueue()));
        }
        treadPool.offer(500);
    }

}
