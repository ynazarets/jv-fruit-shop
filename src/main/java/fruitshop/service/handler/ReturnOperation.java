package fruitshop.service.handler;

import fruitshop.service.common.FruitTransaction;
import fruitshop.storage.Storage;

public class ReturnOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getQuantity() > 0) {
            Storage.add(transaction.getFruit(), transaction.getQuantity());
        } else {
            System.out.println("Invalid quantity. Can not return 0 product.");
        }
    }
}
