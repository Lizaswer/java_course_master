package lrl3.collections;

import java.util.*;

public class CollectionComparison {
    private static final int N = 5_000_000;
    private static final int TEST_SIZE = 1000;

    public static void main(String[] args) {
        System.out.println("=== СРАВНЕНИЕ КОЛЛЕКЦИЙ (Вариант 5) ===");
        System.out.println("Коллекции: ArrayDeque, ArrayList, SortedSet\n");

        System.out.println("Таблица 1. Добавление элементов (мс)");
        System.out.println("-".repeat(80));
        System.out.printf("%-15s | %-20s | %-20s | %-20s\n",
                "Коллекция", "в начало", "в середину", "в конец");
        System.out.println("-".repeat(80));

        System.out.printf("%-15s | %-20d | %-20d | %-20d\n",
                "ArrayList", addToBeginningArrayList(), addToMiddleArrayList(), addToEndArrayList());

        System.out.printf("%-15s | %-20d | %-20s | %-20d\n",
                "ArrayDeque", addToBeginningArrayDeque(), "N/A", addToEndArrayDeque());

        System.out.printf("%-15s | %-20s | %-20s | %-20d\n",
                "SortedSet", "N/A", "N/A", addToEndTreeSet());

        // Таблица 2: Удаление
        System.out.println("\nТаблица 2. Удаление элементов (мс)");
        System.out.println("-".repeat(80));
        System.out.printf("%-15s | %-20s | %-20s | %-20s\n",
                "Коллекция", "в начале", "в середине", "в конце");
        System.out.println("-".repeat(80));

        System.out.printf("%-15s | %-20d | %-20d | %-20d\n",
                "ArrayList", removeFromBeginningArrayList(), removeFromMiddleArrayList(), removeFromEndArrayList());

        System.out.printf("%-15s | %-20d | %-20s | %-20d\n",
                "ArrayDeque", removeFromBeginningArrayDeque(), "N/A", removeFromEndArrayDeque());

        System.out.printf("%-15s | %-20s | %-20s | %-20s\n",
                "SortedSet", "N/A", "N/A", "N/A");

        System.out.println("\nТаблица 3. Получение элемента по индексу (мс)");
        System.out.println("-".repeat(60));
        System.out.printf("%-20s | %-25s\n", "Коллекция", "по индексу");
        System.out.println("-".repeat(60));

        System.out.printf("%-20s | %-25d\n", "ArrayList", getByIndexArrayList());
        System.out.printf("%-20s | %-25s\n", "ArrayDeque", "N/A");
        System.out.printf("%-20s | %-25s\n", "SortedSet", "N/A");
    }

    static long addToBeginningArrayList() {
        List<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) list.add(0, i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long addToMiddleArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) list.add(N/2, i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long addToEndArrayList() {
        List<Integer> list = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) list.add(i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long addToBeginningArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.addFirst(i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long addToEndArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.addLast(i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long addToEndTreeSet() {
        SortedSet<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) set.add(i);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromBeginningArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) list.remove(0);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromMiddleArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) list.remove(N/2);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromEndArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) list.remove(list.size() - 1);
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromBeginningArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) deque.addLast(i);
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.removeFirst();
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long removeFromEndArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) deque.addLast(i);
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) deque.removeLast();
        return (System.nanoTime() - start) / 1_000_000;
    }

    static long getByIndexArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) list.get(i);
        return (System.nanoTime() - start) / 1_000_000;
    }
}
