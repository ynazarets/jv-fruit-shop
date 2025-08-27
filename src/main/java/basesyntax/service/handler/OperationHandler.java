package basesyntax.service.handler;

import basesyntax.service.common.FruitTransaction;

public interface OperationHandler {
    void apply(FruitTransaction transaction);
}
