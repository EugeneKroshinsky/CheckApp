package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.utils.Printer;

public class CheckRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        CheckCommandHandler checkCommandHandler = new CheckCommandHandler(printer);
        checkCommandHandler.execute(args);
    }
}
