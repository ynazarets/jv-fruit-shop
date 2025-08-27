package fruitshop.service.shop;

import fruitshop.service.common.FruitTransaction;
import fruitshop.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
