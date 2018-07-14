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
                Integer version1 = modelFirst.getVersion();
                nonBlock.update(modelFirst, version1);
            }
        };

        Thread secondThread = new Thread() {
            @Override
            public void run() {
                modelFirst.setModelName("change model 1 by secondThread");
                Integer version2 = modelFirst.getVersion();
                nonBlock.update(modelFirst, version2);
            }
        };
        firstThread.start();
        secondThread.start();
    }

}
