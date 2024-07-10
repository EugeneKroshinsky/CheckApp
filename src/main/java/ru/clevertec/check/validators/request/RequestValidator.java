package main.java.ru.clevertec.check.validators.request;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.request.Request;
import main.java.ru.clevertec.check.validators.arg.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestValidator {
    public List<ValidationError> validate(Request request){
        List<RequestValidation> requestValidations = new ArrayList<>();
        requestValidations.add(new QuantityRequestValidation());
        requestValidations.add(new IdRequestValidation());
        return requestValidations.stream()
                .map(el -> el.validate(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
