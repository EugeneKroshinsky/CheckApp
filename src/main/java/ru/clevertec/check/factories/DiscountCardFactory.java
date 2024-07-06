package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.DiscountCard;

public interface DiscountCardFactory {
    DiscountCard buildProduct(String productString);
}
