package main.java.ru.clevertec.check.validators.check;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.dto.request.Request;
import main.java.ru.clevertec.check.validators.request.RequestValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckValidator {
    public List<ValidationError> validate(Check check){
        List<CheckValidation> checkValidations = new ArrayList<>();
        checkValidations.add(new DebitCardBalanceValidation());
        return checkValidations.stream()
                .map(el -> el.validate(check))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
