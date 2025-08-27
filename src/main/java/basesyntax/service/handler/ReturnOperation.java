package basesyntax.service.handler;

import basesyntax.service.common.FruitTransaction;
import basesyntax.storage.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        validateTransaction(transaction);
        if (transaction.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be less then 0: "
                    + transaction.getQuantity());
        }
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null
                || transaction.getFruit().isBlank()) {
            throw new RuntimeException("Wrong transaction."
                    + " Transaction can not to be null or empty.");
        }
    }
}
