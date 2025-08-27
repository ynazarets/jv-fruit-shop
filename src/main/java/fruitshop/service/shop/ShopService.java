package fruitshop.service.shop;

import fruitshop.service.common.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
