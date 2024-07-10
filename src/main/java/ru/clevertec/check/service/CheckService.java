package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.*;
import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.dto.request.Request;
import main.java.ru.clevertec.check.factories.*;
import main.java.ru.clevertec.check.validators.arg.ArgValidator;
import java.util.List;

public class CheckService {
    private final ArgValidator argValidator;

    public CheckService(ArgValidator argValidator) {
        this.argValidator = argValidator;
    }

    public Check calculate(String[] args) {
        List<ValidationError> errors = argValidator.validate(args);
        return errors.isEmpty() ? getCheck(args) : getCheck(errors);
    }

    private Check getCheck(String[] args) {
        RequestFactory requestFactory = new RequestFactory();
        Request request = requestFactory.buildRequest(args);
        //request validator
        CalculateCheckService calculator = new CalculateCheckService();
        return calculator.calculate(request);
    }
    private Check getCheck(List<ValidationError> errors) {
        return new Check(errors);
    }
}
