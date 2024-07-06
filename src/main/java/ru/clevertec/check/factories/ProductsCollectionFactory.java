package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsCollectionFactory{
    public List<Product> buildProductCollection(String[] args) {
        return getProductMap(args).values().stream().toList();
    }
    private   Map<Integer, Product> getProductMap(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        Map<Integer, Product> products = new HashMap<>();
        for (int i = 0; i < args.length - 2; i++) {
            Product product = productFactory.buildProduct(args[i]);
            int currentId = product.getId();
            if (products.containsKey(currentId)){
                int currentQuantity = products.get(currentId).getQuantity();
                Product newProduct
                        = new Product(currentId, currentQuantity + product.getQuantity());
                products.replace(currentId, newProduct);
            } else {
                products.put(currentId, product);
            }
        }
        return products;
    }
}
