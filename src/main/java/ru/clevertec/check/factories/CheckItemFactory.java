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
        while(i < mutableProductRepositories.size() && j < mutableProducts.size()) {
            if (mutableProductRepositories.get(i).getId() == mutableProducts.get(j).getId()) {
                CheckItem checkItem = new CheckItem();
                checkItem.setId(mutableProducts.get(j).getId());
                checkItem.setQuantity(mutableProducts.get(j).getQuantity());
                checkItem.setQuantityInShop(mutableProductRepositories.get(i).getQuantity());
                checkItem.setPrice(mutableProductRepositories.get(i).getPrice());
                checkItem.setDescription(mutableProductRepositories.get(i).getName());
                double discount = mutableProductRepositories.get(i).isWholesale()
                            && checkItem.getQuantityInShop() >= 5
                        ? 0.10d
                        : (discountCardRepository != null ? discountCardRepository.getPercentage() : 0);
                checkItem.setDiscount(discount);
                checkItem.setTotal(checkItem.getQuantity() * checkItem.getPrice());
                checkItems.add(checkItem);
                i++;
                j++;
            } else if (mutableProductRepositories.get(i).getId() < mutableProducts.get(j).getId()) {
                i++;
            } else {
                j++;
            }
        }

        return checkItems;
    }
}
