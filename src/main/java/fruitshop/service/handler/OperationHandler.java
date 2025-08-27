package fruitshop.service.handler;

import fruitshop.service.common.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
