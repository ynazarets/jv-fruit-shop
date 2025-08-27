package basesyntax.service.shop;

import basesyntax.service.common.FruitTransaction;
import basesyntax.service.handler.OperationHandler;
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
