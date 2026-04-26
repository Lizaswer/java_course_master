package lrl5.examples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Random;

public class Example4Squares {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список: " + "\n");

        for(int i = 0; i < 10; i++) {
            integers.add(random.nextInt(10000));
            System.out.println(integers.get(i));
        }

        List<Integer> interperAfter = squaresList(integers);

        System.out.println("\n" + "Список после возведения в квадрат: " + "\n");

        for (Integer i : interperAfter) {
            System.out.println(i);
        }
    }

    private static List<Integer> squaresList(List<Integer> list) {
        return list.stream().map(x -> x * x).collect(Collectors.toList());
    }
}