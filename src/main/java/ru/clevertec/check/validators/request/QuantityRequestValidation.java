package main.java.ru.clevertec.check.validators.request;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.check.CheckItem;
import main.java.ru.clevertec.check.dto.request.Product;
import main.java.ru.clevertec.check.dto.request.ProductRepository;
import main.java.ru.clevertec.check.dto.request.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuantityRequestValidation implements RequestValidation{
    @Override
    public Optional<ValidationError> validate(Request request) {
        List<CheckItem> mutableCheckItems = new ArrayList<>(request.getCheckItems());
        List<ProductRepository> mutableProductRepositories = new ArrayList<>(request.getProductRepositories());
        mutableCheckItems.sort((el1, el2) -> Integer.compare(el1.getId(), el2.getId()));
        mutableProductRepositories.sort((el1, el2) -> Integer.compare(el1.getId(), el2.getId()));

        try {
            for (int i = 0; i < mutableCheckItems.size(); i++) {
                if (mutableCheckItems.get(i).getQuantity() > mutableProductRepositories.get(i).getQuantity()) {
                    return Optional.of(new ValidationError("BAD REQUEST"));
                }
            }
        } catch (IllegalArgumentException e) {
            return Optional.of(new ValidationError("BAD REQUEST"));
        }
        return Optional.empty();
    }
}
