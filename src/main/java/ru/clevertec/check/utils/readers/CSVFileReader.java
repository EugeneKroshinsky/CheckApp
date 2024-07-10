package main.java.ru.clevertec.check.utils.readers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileReader implements FileReader {
    @Override
    public List<List<String>> read(File file, String delimiter){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine(), delimiter));
            }
        } catch (IOException e) {
            throw new RuntimeException("INTERNAL SERVER ERROR");
            //TODO Сделать вывод в файл
        }
        return records;
    }
    private List<String> getRecordFromLine(String line, String delimiter) throws IOException {
        List<String> values = new ArrayList<>();
        Scanner rowScanner = new Scanner(line);
            rowScanner.useDelimiter(delimiter);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        return values;
    }
}
