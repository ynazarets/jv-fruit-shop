package fruitshop.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitStorage;

    public static void initStorage() {
        fruitStorage = new HashMap<>();
    }

    public static Map<String, Integer> getFruitStorage() {
        return fruitStorage;
    }

    public static void add(String fruit, int quantity) {
        fruitStorage.merge(fruit, quantity, Integer::sum);
    }

    public static void subtract(String fruit, int quantity) {
        fruitStorage.merge(fruit, -quantity, Integer::sum);
    }

    public static void set(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }
}
