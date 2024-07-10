package main.java.ru.clevertec.check.factories;

import main.java.ru.clevertec.check.dto.request.DiscountCardRepository;
import main.java.ru.clevertec.check.utils.readers.FileReader;

import java.io.File;
import java.util.List;

public class DiscountCardRepositoryFactory {
    public List<DiscountCardRepository> buildDiscountCardRepositories(String path, FileReader fileReader) {
        List<List<String>> strings = fileReader.read(new File(path), ";");
        return strings.stream().map(this::buildDiscountCardRepository).toList();
    }

    private DiscountCardRepository buildDiscountCardRepository(List<String> string) {
        DiscountCardRepository discountCardRepository = new DiscountCardRepository();
        try {
            discountCardRepository.setId(Integer.parseInt(string.get(0)));
            discountCardRepository.setNumber(Integer.parseInt(string.get(1)));
            discountCardRepository.setPercentage(Integer.parseInt(string.get(2)) * 0.01);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return discountCardRepository;
    }
}
