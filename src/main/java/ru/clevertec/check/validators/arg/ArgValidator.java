package main.java.ru.clevertec.check.validators.arg;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArgValidator {
    public List<ValidationError> validate(String[] args) {
        List<ArgValidation> argValidations = new ArrayList<>();
        argValidations.add(new NumberOfArgsArgValidation());
        argValidations.add(new DebitCardArgValidation());
        argValidations.add(new DiscountCardArgValidation());
        argValidations.add(new ProductArgValidation());

        return argValidations.stream()
                .map(el -> el.validate(args))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}