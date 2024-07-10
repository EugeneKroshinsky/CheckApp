package main.java.ru.clevertec.check.validators.request;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.request.Request;

import java.util.Optional;

public class IdRequestValidation implements RequestValidation{
    @Override
    public Optional<ValidationError> validate(Request request) {
        return request.getProducts().size() != request.getCheckItems().size()
                ? Optional.of(new ValidationError("BAD REQUEST"))
                : Optional.empty();
    }
}
