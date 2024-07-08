package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.CheckItem;
import main.java.ru.clevertec.check.dto.DiscountCardRepository;
import main.java.ru.clevertec.check.dto.Product;
import main.java.ru.clevertec.check.dto.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckItemFactory {
    public List<CheckItem> buildCheckItem(List<ProductRepository> productRepositories,
                                    List<Product> products,
                                    DiscountCardRepository discountCardRepository) {
        List<CheckItem> checkItems = new ArrayList<>();

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
                String descriprion = productRepositories.get(i).getName();
                CheckItem checkItem = new CheckItem(
                        quantity,
                        price,
                        0d,
                        quantity * price,
                        qtyInShop,
                        descriprion
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
