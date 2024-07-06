package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.factories.*;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.Printer;

public class CheckRunner {
    public static void main(String[] args)
    {
        CheckService checkService = new CheckService();
        ProductFactory productFactory = new ProductFactoryImpl();
        DiscountCardFactory discountCardFactory = new DiscountCardFactoryImpl();
        DebitCardFactory debitCardFactory = new DebitCardFactoryImpl();
        Printer printer = new Printer();

        CheckCommandHandler checkCommandHandler = new CheckCommandHandler(
                checkService,
                productFactory,
                discountCardFactory,
                debitCardFactory,
                printer
        );

        checkCommandHandler.execute(args);
    }
}
