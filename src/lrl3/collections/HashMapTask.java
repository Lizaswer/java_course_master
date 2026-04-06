package lrl3.collections;

import java.util.*;

public class HashMapTask {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(0, "ноль");

        System.out.println("Исходный HashMap: " + map);
        System.out.println("\n=== Результаты ===");

        System.out.print("1. Строки с ключом > 5: ");
        List<String> result1 = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                result1.add(entry.getValue());
            }
        }
        System.out.println(result1);

        if (map.containsKey(0)) {
            System.out.println("2. Строка с ключом 0: " + map.get(0));
        }

        long product = 1;
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
                System.out.println("   Ключ " + entry.getKey() + " (строка: '" +
                        entry.getValue() + "', длина: " +
                        entry.getValue().length() + ")");
            }
        }

        if (found) {
            System.out.println("3. Произведение ключей (длина > 5): " + product);
        } else {
            System.out.println("3. Нет строк с длиной > 5");
        }
    }
}
