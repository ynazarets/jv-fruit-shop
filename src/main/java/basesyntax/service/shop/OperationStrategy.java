package basesyntax.service.shop;

import basesyntax.service.common.FruitTransaction;
import basesyntax.service.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
