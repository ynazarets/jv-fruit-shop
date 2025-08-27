package fruitshop.service.shop;

import fruitshop.service.common.FruitTransaction;
import fruitshop.service.handler.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getOperationHandler(
                    transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
