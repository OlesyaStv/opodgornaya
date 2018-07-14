package ru.job4j.nonblock;

public class NonBlockTest {

    public static void main(String[] args) {
        NonBlock nonBlock = new NonBlock();
        Base  modelFirst = new Base("model 1", 1);
        nonBlock.add(modelFirst);

        Thread firstThread = new Thread() {
            @Override
            public void run() {
                modelFirst.setModelName("change model 1 by firstThread");
                nonBlock.update(modelFirst);

            }
        };

        Thread secondThread = new Thread() {
            @Override
            public void run() {
                modelFirst.setModelName("change model 1 by secondThread");
                nonBlock.update(modelFirst);
            }
        };
        firstThread.start();
        secondThread.start();
    }

}
