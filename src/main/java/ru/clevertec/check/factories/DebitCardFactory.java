package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.request.DebitCard;

public class DebitCardFactory {
    public DebitCard buildProduct(String productString){
        String[] parts = productString.split("=");
        double balance = Double.parseDouble(parts[1]);
        return new DebitCard(balance);
    }
}
