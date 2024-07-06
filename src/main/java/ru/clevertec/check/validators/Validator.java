package main.java.ru.clevertec.check.validators;

import main.java.ru.clevertec.check.dto.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Validator{
    public List<ValidationError> validate(String[] args) {
        List<Validation> validations = new ArrayList<>();
        validations.add(new NumberOfArgsValidation());

        return validations.stream()
                .map(el -> el.validate(args))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}