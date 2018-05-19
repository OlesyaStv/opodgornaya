package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                while (this.rect.getX() != 300) {
                    this.rect.setX(this.rect.getX() + 1);
                    Thread.sleep(50);
                }
                while (this.rect.getX() != 0) {
                    this.rect.setX(this.rect.getX() - 1);
                    Thread.sleep(50);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}