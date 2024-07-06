package main.java.ru.clevertec.check;

public class CheckRunner {
    public static void main(String[] args) {
        CheckCommandHandler checkCommandHandler = new CheckCommandHandler();
        checkCommandHandler.execute(args);
    }
}
