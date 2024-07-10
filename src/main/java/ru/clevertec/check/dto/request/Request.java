package main.java.ru.clevertec.check.dto.request;

import main.java.ru.clevertec.check.dto.check.CheckItem;

import java.util.List;
import java.util.StringJoiner;

public class Request {
    private List<CheckItem> checkItems;
    private DiscountCardRepository discountCard;
    private DebitCard debitCard;

    private List<ProductRepository> productRepositories;
    private List<Product> products;

    public Request(List<CheckItem> checkItems,
                   DiscountCardRepository discountCard,
                   DebitCard debitCard,
                   List<ProductRepository> productRepositories,
                   List<Product> products) {
        this.checkItems = checkItems;
        this.discountCard = discountCard;
        this.debitCard = debitCard;
        this.productRepositories = productRepositories;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public DiscountCardRepository getDiscountCard() {
        return discountCard;
    }

    public List<CheckItem> getCheckItems() {
        return checkItems;
    }

    public List<ProductRepository> getProductRepositories() {
        return productRepositories;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
                .add("products=" + checkItems)
                .add("discountCard=" + discountCard)
                .add("debitCard=" + debitCard)
                .toString();
    }
}
