package ru.job4j.application;

//public class ValidateInput extends ConsoleInput {
//
//    @Override
//    public int ask(String question, int[] range) {
//        boolean invalid = true;
//        int value = -1;
//        do {
//            try {
//                value = super.ask(question, range);
//                invalid = false;
//            } catch (MenuOutException moe) {
//                System.out.println("Select menu key");
//            } catch (NumberFormatException nfe) {
//                System.out.println("Please enter validate date");
//            }
//        } while (invalid);
//        return value;
//    }
//}

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
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
