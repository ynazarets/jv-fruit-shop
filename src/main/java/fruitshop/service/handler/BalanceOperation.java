package fruitshop.service.handler;

import fruitshop.service.common.FruitTransaction;
import fruitshop.storage.Storage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() >= 0) {
            Storage.set(transaction.getFruit(), transaction.getQuantity());
        } else {
            System.out.println("Invalid quantity. Can not have -0 product.");
        }
    }
}
