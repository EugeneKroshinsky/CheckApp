package main.java.ru.clevertec.check.validators.check;

import main.java.ru.clevertec.check.dto.ValidationError;
import main.java.ru.clevertec.check.dto.check.Check;

import java.util.Optional;

public class DebitCardBalanceValidation implements CheckValidation{
    @Override
    public Optional<ValidationError> validate(Check check) {
        return check.getDebitCard().getBalance() < check.getTotalWithDiscount()
                ? Optional.of(new ValidationError("NOT ENOUGH MONEY"))
                : Optional.empty();
    }
}
