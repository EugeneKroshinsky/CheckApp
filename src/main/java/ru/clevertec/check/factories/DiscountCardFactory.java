package main.java.ru.clevertec.check.factories;


import main.java.ru.clevertec.check.dto.DiscountCard;

public class DiscountCardFactory {

    public DiscountCard buildProduct(String productString){
        String[] parts = productString.split("=");

        //TODO: add exceptions

        int number = Integer.parseInt(parts[1]);
        return new DiscountCard(number);
    }
}
