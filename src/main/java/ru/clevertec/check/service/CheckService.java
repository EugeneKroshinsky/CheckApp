package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.dto.*;
import main.java.ru.clevertec.check.dto.check.Check;
import main.java.ru.clevertec.check.dto.request.Request;
import main.java.ru.clevertec.check.factories.*;
import main.java.ru.clevertec.check.validators.arg.ArgValidator;
import main.java.ru.clevertec.check.validators.check.CheckValidator;
import main.java.ru.clevertec.check.validators.request.RequestValidator;

import java.util.List;

public class CheckService {
    private ArgValidator argValidator;
    private RequestFactory requestFactory;
    private RequestValidator requestValidator;
    private CalculateCheckService calculator;
    private  CheckValidator checkValidator;

    public CheckService(ArgValidator argValidator,
                        RequestFactory requestFactory,
                        RequestValidator requestValidator,
                        CalculateCheckService calculator,
                        CheckValidator checkValidator) {
        this.argValidator = argValidator;
        this.requestFactory = requestFactory;
        this.requestValidator = requestValidator;
        this.calculator = calculator;
        this.checkValidator = checkValidator;
    }

    public Check calculate(String[] args) {
        List<ValidationError> errors = argValidator.validate(args);
        return errors.isEmpty() ? validateRequest(args) : getCheck(errors);
    }

    private Check validateRequest(String[] args) {
        Request request = requestFactory.buildRequest(args);
        List<ValidationError> errors = requestValidator.validate(request);
        return errors.isEmpty() ? getCheck(request) : getCheck(errors);
    }
    private Check getCheck(Request request) {
        Check check = calculator.calculate(request);
        List<ValidationError> errors = checkValidator.validate(check);
        return errors.isEmpty() ? check : getCheck(errors);
    }
    private Check getCheck(List<ValidationError> errors) {
        return new Check(errors);
    }
}
