package ru.job4j.pseudo;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Square square = new Square();
        Paint paint = new Paint();
        paint.draw(triangle);
        paint.draw(square);
    }
}