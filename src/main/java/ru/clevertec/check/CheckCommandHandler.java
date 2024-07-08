package main.java.ru.clevertec.check;
import main.java.ru.clevertec.check.dto.Check;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.ConsoleWriter;
import main.java.ru.clevertec.check.utils.Printer;
import main.java.ru.clevertec.check.validators.arg.ArgValidator;

public class CheckCommandHandler {

    public CheckCommandHandler() {
    }

    public void execute(String[] args) {
        ArgValidator argValidator = new ArgValidator();
        CheckService checkService = new CheckService(argValidator);

        Check check = checkService.calculate(args);

        Printer printer = new Printer();
        printer.setCheckWriter(new ConsoleWriter());
        printer.print(check);
    }
}