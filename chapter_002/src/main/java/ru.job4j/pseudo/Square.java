package ru.job4j.pseudo;

public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("+  +");
        pic.append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square.draw());

    }
}