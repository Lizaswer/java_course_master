package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task9GreaterThan {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 3, 15);
        int threshold = 10;
        List<Integer> result = getGreaterThan(numbers, threshold);
        System.out.println("Больше " + threshold + ": " + result);
    }

    public static List<Integer> getGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n > threshold)
                .collect(Collectors.toList());
    }
}
