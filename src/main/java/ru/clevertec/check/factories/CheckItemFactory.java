package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.check.CheckItem;
import main.java.ru.clevertec.check.dto.request.DiscountCardRepository;
import main.java.ru.clevertec.check.dto.request.Product;
import main.java.ru.clevertec.check.dto.request.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckItemFactory {
    public List<CheckItem> buildCheckItem(List<ProductRepository> productRepositories,
                                          List<Product> products,
                                          DiscountCardRepository discountCardRepository) {
        List<CheckItem> checkItems = new ArrayList<>();
        //TODO: Разбить на разные методы и классы
        List<ProductRepository> mutableProductRepositories = new ArrayList<>(productRepositories);
        List<Product> mutableProducts = new ArrayList<>(products);
        mutableProductRepositories.sort((el1, el2) -> Integer.compare(el1.getId(), el2.getId()));
        mutableProducts.sort((el1, el2) -> Integer.compare(el1.getId(), el2.getId()));

        int i = 0, j = 0;
        while(i < productRepositories.size() && j < products.size()) {
            if (productRepositories.get(i).getId() == products.get(j).getId()) {
                int quantity = products.get(j).getQuantity();
                int qtyInShop = productRepositories.get(i).getQuantity();
                double price = productRepositories.get(i).getPrice();
                String description = productRepositories.get(i).getName();
                double discount = 0;
                if(productRepositories.get(i).isWholesale() && qtyInShop >= 5) {
                   discount = 0.10d; //TODO считывать из файла .properties
                } else if (discountCardRepository != null) {
                    discount = discountCardRepository.getPercentage();
                }

                double total = quantity * price;
                CheckItem checkItem = new CheckItem(
                        quantity,
                        price,
                        discount * total,
                        total,
                        qtyInShop,
                        description
                );
                checkItems.add(checkItem);
                i++;
                j++;
            } else if (productRepositories.get(i).getId() < products.get(j).getId()) {
                i++;
            } else {
                j++;
            }
        }

        return checkItems;
    }
}
