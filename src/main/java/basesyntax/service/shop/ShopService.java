package basesyntax.service.shop;

import basesyntax.service.common.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
