package main.java.ru.clevertec.check.validators.request;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.request.Request;

import java.util.Optional;

public interface RequestValidation {
    Optional<ValidationError> validate(Request request);
}
