package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.Product;

public class ProductFactoryImpl implements ProductFactory {
    @Override
    public Product buildProduct(String productString){
        String[] parts = productString.split("-");

        //TODO: add exceptions

        int id = Integer.parseInt(parts[0]);
        int quantity = Integer.parseInt(parts[1]);
        return new Product(id, quantity);
    }
}
