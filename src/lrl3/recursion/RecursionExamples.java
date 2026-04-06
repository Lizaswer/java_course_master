package lrl3.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionExamples {

    public static void example1(int x) {
        if (x >= 20) return;
        System.out.print(x + " ");
        example1(2 * x + 1);
    }

    public static void example2(int x) {
        if (x >= 20) return;
        example2(2 * x + 1);
        System.out.print(x + " ");
    }

    public static void example3(int x, int depth) {
        if (x >= 20) return;
        System.out.println("Вход: x=" + x + ", глубина=" + depth);
        example3(2 * x + 1, depth + 1);
        System.out.println("Выход: x=" + x + ", глубина=" + depth);
    }

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }


    public static long fibonacci(int n, List<String> tree, String prefix) {
        tree.add(prefix + "fib(" + n + ")");
        if (n == 0) return 0;
        if (n == 1) return 1;
        long result = fibonacci(n - 1, tree, prefix + "  ") +
                fibonacci(n - 2, tree, prefix + "  ");
        tree.add(prefix + "-> fib(" + n + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Пример 1 (прямой порядок) ===");
        example1(1);

        System.out.println("\n\n=== Пример 2 (обратный порядок) ===");
        example2(1);

        System.out.println("\n\n=== Пример 3 (глубина рекурсии) ===");
        example3(1, 1);

        System.out.println("\n=== Пример 4 (факториал) ===");
        System.out.println("5! = " + factorial(5));
        System.out.println("10! = " + factorial(10));

        System.out.println("\n=== Пример 5 (Фибоначчи) ===");
        List<String> tree = new ArrayList<>();
        long result = fibonacci(8, tree, "");
        System.out.println("fib(8) = " + result);
        System.out.println("\nДерево рекурсивных вызовов:");
        for (String node : tree) {
            System.out.println(node);
        }
    }
}
