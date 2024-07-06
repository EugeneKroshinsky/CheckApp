package main.java.ru.clevertec.check;
import main.java.ru.clevertec.check.dto.Check;
import main.java.ru.clevertec.check.factories.DebitCardFactory;
import main.java.ru.clevertec.check.factories.DiscountCardFactory;
import main.java.ru.clevertec.check.factories.ProductsCollectionFactory;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.utils.ConsoleWriter;
import main.java.ru.clevertec.check.utils.Printer;
import main.java.ru.clevertec.check.validators.Validator;

public class CheckCommandHandler {

    public CheckCommandHandler() {
    }

    public void execute(String[] args) {
        ProductsCollectionFactory productsCollectionFactory = new ProductsCollectionFactory();
        DiscountCardFactory discountCardFactory = new DiscountCardFactory();
        DebitCardFactory debitCardFactory = new DebitCardFactory();
        Validator validator = new Validator();

        CheckService checkService = new CheckService(
                productsCollectionFactory,
                discountCardFactory,
                debitCardFactory,
                validator
        );

        Check check = checkService.calculate(args);

        Printer printer = new Printer();
        printer.setCheckWriter(new ConsoleWriter());
        printer.print(check);
    }
}