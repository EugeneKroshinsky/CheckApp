package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.factories.*;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.Printer;

public class CheckRunner {
    public static void main(String[] args)
    {
        CheckService checkService = new CheckService();
        ProductsCollectionFactory productsCollectionFactory = new ProductsCollectionFactory();
        DiscountCardFactory discountCardFactory = new DiscountCardFactory();
        DebitCardFactory debitCardFactory = new DebitCardFactory();
        Printer printer = new Printer();

        CheckCommandHandler checkCommandHandler = new CheckCommandHandler(
                checkService,
                productsCollectionFactory,
                discountCardFactory,
                debitCardFactory,
                printer
        );

        checkCommandHandler.execute(args);
    }
}
