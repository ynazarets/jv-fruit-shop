package fruitshop.service.converter;

import fruitshop.service.common.FruitTransaction;
import java.util.List;

interface DataConverter {
    List<FruitTransaction> convertToTransaction(List<String> rawData);
}
