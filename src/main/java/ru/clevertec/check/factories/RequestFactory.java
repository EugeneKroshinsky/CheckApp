package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.*;
import main.java.ru.clevertec.check.utils.CSVFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestFactory {
    public Request buildRequest(String[] args) {
        ProductsCollectionFactory productsCollectionFactory = new ProductsCollectionFactory();
        DiscountCardFactory discountCardFactory = new DiscountCardFactory();
        DebitCardFactory debitCardFactory = new DebitCardFactory();
        ProductRepositoryFactory productRepositoryFactory = new ProductRepositoryFactory();
        CheckItemFactory checkItemFactory = new CheckItemFactory();

        List<Product> products = productsCollectionFactory.buildProductCollection(
                Arrays.copyOf(args, args.length - 2)
        );
        DiscountCard discountCard = discountCardFactory.buildProduct(args[args.length - 2]);
        DebitCard debitCard = debitCardFactory.buildProduct(args[args.length - 1]);
        List<ProductRepository> productRepositories = productRepositoryFactory.buildProductRepositories(
                "C:/github/check/src/main/java/resources/products.csv",
                new CSVFileReader()
        );

        List<DiscountCardRepository> discountCardRepositories = null; //TODO
        DiscountCardRepository clientDiscountCard = null;

        List<CheckItem> checkItems = checkItemFactory.buildCheckItem(productRepositories, products, clientDiscountCard);
        return new Request(checkItems, null, debitCard);
    }
}
