package main.java.ru.clevertec.check.factories;


import main.java.ru.clevertec.check.dto.Product;

public interface ProductFactory {
    Product buildProduct(String productString);
}
