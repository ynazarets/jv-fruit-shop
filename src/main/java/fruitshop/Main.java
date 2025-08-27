package fruitshop;

import fruitshop.service.common.FruitTransaction;
import fruitshop.service.handler.OperationHandler;
import fruitshop.service.handler.PurchaseOperation;
import fruitshop.service.handler.ReturnOperation;
import fruitshop.service.handler.SupplyOperation;
import fruitshop.service.shop.OperationStrategy;
import fruitshop.service.shop.ShopServiceImpl;
import fruitshop.storage.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Storage.initStorage();
        Storage.set("apple", 0);
        Storage.set("banana", 0);
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = handlerMap::get;
        ShopServiceImpl shopService = new ShopServiceImpl(operationStrategy);
        List<FruitTransaction> transactions = List.of(
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 100),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 100),
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 3),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "banana", 100),
                new FruitTransaction(FruitTransaction.Operation.SUPPLY, "apple", 100),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 3),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "apple", 35),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 21),
                new FruitTransaction(FruitTransaction.Operation.PURCHASE, "banana", 9)
        );
        shopService.process(transactions);
        System.out.println(Storage.getFruitStorage());
    }
}
