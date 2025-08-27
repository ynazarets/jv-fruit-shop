package fruitshop.service.converter;

import fruitshop.service.common.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        return rawData.stream()
                .skip(1)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid String format.");
            }
            return new FruitTransaction(
                    FruitTransaction.Operation.fromCode(parts[0].trim()),
                    parts[1].trim(),
                    Integer.parseInt(parts[2].trim())
            );
        } catch (Exception e) {
            throw new RuntimeException("Exception by parsing line" + line, e);
        }
    }

}
