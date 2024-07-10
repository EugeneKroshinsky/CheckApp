package main.java.ru.clevertec.check;
import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.factories.RequestFactory;
import main.java.ru.clevertec.check.service.CalculateCheckService;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.writers.ConsoleWriter;
import main.java.ru.clevertec.check.utils.writers.CsvWriter;
import main.java.ru.clevertec.check.utils.Printer;
import main.java.ru.clevertec.check.validators.arg.ArgValidator;
import main.java.ru.clevertec.check.validators.check.CheckValidator;
import main.java.ru.clevertec.check.validators.request.RequestValidator;

import java.io.IOException;

public class CheckCommandHandler {
    Printer printer;
    public CheckCommandHandler() {
    }

    public CheckCommandHandler(Printer printer) {
        this.printer = printer;
    }

    public void execute(String[] args)   {
        RequestFactory requestFactory = new RequestFactory();
        ArgValidator argValidator = new ArgValidator();
        RequestValidator requestValidator = new RequestValidator();
        CheckValidator checkValidator = new CheckValidator();
        CalculateCheckService calculator = new CalculateCheckService();

        CheckService checkService = new CheckService(
                argValidator,
                requestFactory,
                requestValidator,
                calculator,
                checkValidator
        );

        Check check = checkService.calculate(args);
        printResult(check);
    }
    private void printResult(Check check) {
        try {
            printer.setCheckWriter(new ConsoleWriter("dd.MM.yyyy", "HH:mm:ss", "#.##"));
            printer.print(check);
            printer.setCheckWriter(new CsvWriter("dd.MM.yyyy", "HH:mm:ss", "#.##", ";"));
            printer.print(check);
        } catch(IOException e) {
            throw new RuntimeException("INTERNAL SERVER ERROR");
            //TODO сделать вывод в файл
        }
    }
}