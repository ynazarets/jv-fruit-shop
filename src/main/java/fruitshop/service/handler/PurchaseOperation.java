package fruitshop.service.handler;

import fruitshop.service.common.FruitTransaction;
import fruitshop.storage.Storage;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = Storage.getFruitStorage().get(transaction.getFruit());
        if (!(currentQuantity - transaction.getQuantity() < 0)) {
            Storage.subtract(transaction.getFruit(), transaction.getQuantity());
        } else {
            System.out.println("Can not sell this product. "
                    + "To small quantity in storage");
        }
    }
}
