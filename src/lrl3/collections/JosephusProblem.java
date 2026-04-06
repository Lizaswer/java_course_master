package lrl3.collections;

import java.util.*;

public class JosephusProblem {

    public static int josephusArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static int josephusLinkedList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 50000};

        System.out.println("=== Задача Иосифа (вычеркивается каждый второй) ===\n");
        System.out.println("N\t\tArrayList (мс)\tLinkedList (мс)");
        System.out.println("=".repeat(50));

        for (int n : sizes) {
            long start = System.nanoTime();
            int result1 = josephusArrayList(n);
            long timeArrayList = (System.nanoTime() - start) / 1_000_000;

            start = System.nanoTime();
            int result2 = josephusLinkedList(n);
            long timeLinkedList = (System.nanoTime() - start) / 1_000_000;

            System.out.printf("%d\t\t%d\t\t%d\n", n, timeArrayList, timeLinkedList);
        }

        System.out.println("\n=== ВЫВОД ===");
        System.out.println("ArrayList работает быстрее, потому что:");
        System.out.println("1. Лучшая локальность данных (кэш процессора)");
        System.out.println("2. При удалении из ArrayList сдвиг элементов происходит в непрерывной памяти");
        System.out.println("3. LinkedList требует O(n) для доступа к элементу по индексу");
    }
}