package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task7DivisibleBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 35);
        int divisor = 5;
        List<Integer> result = getDivisibleBy(numbers, divisor);
        System.out.println("Делятся на " + divisor + ": " + result);
    }

    public static List<Integer> getDivisibleBy(List<Integer> list, int divisor) {
        return list.stream()
                .filter(n -> n % divisor == 0)
                .collect(Collectors.toList());
    }
}
