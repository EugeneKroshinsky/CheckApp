package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.request.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsCollectionFactory{
    public List<Product> buildProductCollection(String[] args) {
        return getProductMap(args).values().stream().toList();
    }
    private   Map<Integer, Product> getProductMap(String[] args) {
        Map<Integer, Product> products = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            Product product = buildProduct(args[i]);
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
    private Product buildProduct(String productString){
        String[] parts = productString.split("-");

        //TODO: add exceptions

        int id = Integer.parseInt(parts[0]);
        int quantity = Integer.parseInt(parts[1]);
        return new Product(id, quantity);
    }
}
