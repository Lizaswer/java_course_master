package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task11LessThan {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 20, 3, 15);
        int threshold = 10;
        List<Integer> result = getLessThan(numbers, threshold);
        System.out.println("Меньше " + threshold + ": " + result);
    }

    public static List<Integer> getLessThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(n -> n < threshold)
                .collect(Collectors.toList());
    }
}