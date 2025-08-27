package fruitshop.service.handler;

import fruitshop.service.common.FruitTransaction;
import fruitshop.storage.Storage;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() > 0) {
            Storage.add(transaction.getFruit(), transaction.getQuantity());
        } else {
            System.out.println("Invalid quantity. Can not supply 0 product.");
        }
    }
}
