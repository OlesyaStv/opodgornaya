package ru.job4j.application;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Select menu key");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date");
            }
        } while (invalid);
        return value;
    }
}
