package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.check.CheckItem;
import main.java.ru.clevertec.check.dto.request.*;
import main.java.ru.clevertec.check.utils.readers.CSVFileReader;
import main.java.ru.clevertec.check.utils.readers.FileReader;

import java.util.Arrays;
import java.util.List;

public class RequestFactory {
    public Request buildRequest(String[] args) {
        ProductsCollectionFactory productsCollectionFactory = new ProductsCollectionFactory();
        DiscountCardFactory discountCardFactory = new DiscountCardFactory();
        DebitCardFactory debitCardFactory = new DebitCardFactory();
        ProductRepositoryFactory productRepositoryFactory = new ProductRepositoryFactory();
        CheckItemFactory checkItemFactory = new CheckItemFactory();
        DiscountCardRepositoryFactory discountCardRepositoryFactory = new DiscountCardRepositoryFactory();
        FileReader fileReader = new CSVFileReader();
        List<Product> products = productsCollectionFactory.buildProductCollection(
                Arrays.copyOf(args, args.length - 2)
        );
        DiscountCard discountCard = discountCardFactory.buildProduct(args[args.length - 2]);
        DebitCard debitCard = debitCardFactory.buildProduct(args[args.length - 1]);

        List<ProductRepository> productRepositories = productRepositoryFactory.buildProductRepositories(
                "C:/github/check/src/main/java/resources/products.csv",
                fileReader
        );

        List<DiscountCardRepository> discCardRepositories = discountCardRepositoryFactory.buildDiscountCardRepositories(
                "C:/github/check/src/main/java/resources/discountCards.csv",
                fileReader
        );
        DiscountCardRepository clientCard = discCardRepositories.stream()
                .filter(el -> el.getNumber() == discountCard.getNumber())
                .findAny()
                .orElse(null);

        List<CheckItem> checkItems = checkItemFactory.buildCheckItem(
                productRepositories,
                products,
                clientCard
        );

        return new Request(checkItems, clientCard, debitCard);
    }
}
