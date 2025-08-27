package basesyntax.service.converter;

import basesyntax.service.common.FruitTransaction;
import java.util.List;

public interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> rawData);
}
