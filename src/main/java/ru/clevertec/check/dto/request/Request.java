package main.java.ru.clevertec.check.dto.request;

import main.java.ru.clevertec.check.dto.check.CheckItem;

import java.util.List;
import java.util.StringJoiner;

public class Request {
    private List<CheckItem> products;
    private DiscountCardRepository discountCard;
    private DebitCard debitCard;

    public Request(List<CheckItem> products, DiscountCardRepository discountCard, DebitCard debitCard) {
        this.products = products;
        this.discountCard = discountCard;
        this.debitCard = debitCard;
    }

    public List<CheckItem> getProducts() {
        return products;
    }

    public DiscountCardRepository getDiscountCard() {
        return discountCard;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
                .add("products=" + products)
                .add("discountCard=" + discountCard)
                .add("debitCard=" + debitCard)
                .toString();
    }
}
