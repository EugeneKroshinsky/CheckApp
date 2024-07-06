package main.java.ru.clevertec.check;

import main.java.ru.clevertec.check.dto.Check;
import main.java.ru.clevertec.check.dto.DebitCard;
import main.java.ru.clevertec.check.dto.DiscountCard;
import main.java.ru.clevertec.check.dto.Product;
import main.java.ru.clevertec.check.factories.*;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.CheckWriter;
import main.java.ru.clevertec.check.utils.ConsoleWriter;
import main.java.ru.clevertec.check.utils.CsvWriter;
import main.java.ru.clevertec.check.utils.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckCommandHandler {

    private final CheckService checkService;
    private final ProductFactory productFactory;
    private final DiscountCardFactory discountCardFactory;
    private final DebitCardFactory debitCardFactory;
    private final Printer printer;

    public CheckCommandHandler(CheckService checkService,
                               ProductFactory productFactory,
                               DiscountCardFactory discountCardFactory,
                               DebitCardFactory debitCardFactory,
                               Printer printer) {
        this.checkService = checkService;
        this.productFactory = productFactory;
        this.discountCardFactory = discountCardFactory;
        this.debitCardFactory = debitCardFactory;
        this.printer = printer;
    }

    public void execute(String[] args) {
        List<Product> products = getProductsFromArgs(args);
        DiscountCard discountCard = getDiscountCardFromArgs(args);
        DebitCard debitCard = getDebitCardFromArgs(args);

        products.forEach(System.out::println);
        System.out.println(discountCard);
        System.out.println(debitCard);

/*        Check check = checkService.calculate(products, discountCard, debitCard);

        printCheck(printer, new CsvWriter(), check);
        printCheck(printer, new ConsoleWriter(), check);*/
    }
    private List<Product> getProductsFromArgs(String[] args) {
        return Arrays.stream(args, 0, args.length - 2)
                .map(productFactory::buildProduct)
                .collect(Collectors.toList());
    }
    private DiscountCard getDiscountCardFromArgs(String[] args) {
        return discountCardFactory.buildProduct(args[args.length - 2]);
    }
    private DebitCard getDebitCardFromArgs(String[] args) {
        return debitCardFactory.buildProduct(args[args.length - 1]);
    }
    private void printCheck(Printer printer, CheckWriter checkWriter, Check check) {
        printer.setCheckWriter(checkWriter);
        printer.print(check);
    }
}