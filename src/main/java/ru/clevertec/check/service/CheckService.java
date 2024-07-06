package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.*;
import main.java.ru.clevertec.check.factories.DebitCardFactory;
import main.java.ru.clevertec.check.factories.DiscountCardFactory;
import main.java.ru.clevertec.check.factories.ProductsCollectionFactory;
import main.java.ru.clevertec.check.validators.Validator;

import java.util.Arrays;
import java.util.List;

public class CheckService {
    private final ProductsCollectionFactory productsCollectionFactory;
    private final DiscountCardFactory discountCardFactory;
    private final DebitCardFactory debitCardFactory;
    private final Validator validator;

    public CheckService(ProductsCollectionFactory productsCollectionFactory,
                        DiscountCardFactory discountCardFactory,
                        DebitCardFactory debitCardFactory,
                        Validator validator) {
        this.productsCollectionFactory = productsCollectionFactory;
        this.discountCardFactory = discountCardFactory;
        this.debitCardFactory = debitCardFactory;
        this.validator = validator;
    }

    public Check calculate(String[] args) {
        List<ValidationError> errors = validator.validate(args);
        return errors != null ? getCheck(errors) : getCheck(args);
    }
    private Check getCheck(String[] args) {
        List<Product> products = productsCollectionFactory.buildProductCollection(
                Arrays.copyOf(args, args.length - 2)
        );
        DiscountCard discountCard = discountCardFactory.buildProduct(args[args.length - 2]);
        DebitCard debitCard = debitCardFactory.buildProduct(args[args.length - 1]);

        CalculateCheckService calculator = new CalculateCheckService();
        return calculator.calculate(products, discountCard, debitCard);

    }
    private Check getCheck(List<ValidationError> errors) {
        return new Check(errors);
    }
}
