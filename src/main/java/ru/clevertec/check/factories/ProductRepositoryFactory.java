package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.ProductRepository;
import main.java.ru.clevertec.check.dto.Request;
import main.java.ru.clevertec.check.utils.FileReader;

import java.io.File;
import java.util.List;

public class ProductRepositoryFactory {
    public List<ProductRepository> buildProductRepositories(String path, FileReader fileReader) {
        List<List<String>> strings = fileReader.read(new File(path), ";");
        return strings.stream().map(this::buildProductRepository).toList();
    }
    private ProductRepository buildProductRepository(List<String> string) {
        ProductRepository productRepository = new ProductRepository();
        try {
           productRepository.setId(Integer.parseInt(string.get(0)));
           productRepository.setName(string.get(1));
           productRepository.setPrice(Double.parseDouble(string.get(2)));
           productRepository.setQuantity(Integer.parseInt(string.get(3)));
           if (string.get(4).equals("+")) {
               productRepository.setWholesale(true);
           } else if (string.get(4).equals("-")) {
               productRepository.setWholesale(false);
           } else {
               throw new RuntimeException();
           }

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return productRepository;
    }
}
