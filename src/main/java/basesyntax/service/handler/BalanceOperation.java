package basesyntax.service.handler;

import basesyntax.service.common.FruitTransaction;
import basesyntax.storage.Storage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        validateTransaction(transaction);
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid quantity for operation BALANCE: "
                    + transaction.getQuantity());
        }
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }

    private void validateTransaction(FruitTransaction transaction) {
        if (transaction == null || transaction.getFruit() == null
                || transaction.getFruit().isBlank()) {
            throw new RuntimeException("Invalid transaction:"
                    + " Fruit name cannot be null or empty.");
        }
    }
}
