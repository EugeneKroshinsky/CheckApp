package main.java.ru.clevertec.check;
import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.wrtiters.ConsoleWriter;
import main.java.ru.clevertec.check.utils.wrtiters.CsvWriter;
import main.java.ru.clevertec.check.utils.Printer;
import main.java.ru.clevertec.check.validators.arg.ArgValidator;

import java.io.IOException;

public class CheckCommandHandler {

    public CheckCommandHandler() {
    }

    public void execute(String[] args)   {
        ArgValidator argValidator = new ArgValidator();
        CheckService checkService = new CheckService(argValidator);

        Check check = checkService.calculate(args);

        try {
            Printer printer = new Printer();
            printer.setCheckWriter(new ConsoleWriter("dd.MM.yyyy", "HH:mm:ss", "#.##"));
            printer.print(check);
            printer.setCheckWriter(new CsvWriter("dd.MM.yyyy", "HH:mm:ss", "#.##", ";"));
            printer.print(check);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }



    }
}