package ru.job4j.treadpools;

import org.junit.Test;
import ru.job4j.treadpools.TreadPool;

public class TreadPoolTest {

    @Test
    public void whenTest() throws InterruptedException {
        TreadPool treadPool = new TreadPool();
        treadPool.startThreads();
        treadPool.work(new Thread());
        treadPool.shutdown();
    }
}
