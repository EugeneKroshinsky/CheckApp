package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.DebitCard;

public interface DebitCardFactory {
    DebitCard buildProduct(String productString);
}
