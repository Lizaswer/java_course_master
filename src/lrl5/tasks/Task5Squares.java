package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task5Squares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = getSquares(numbers);
        System.out.println("Квадраты: " + squares);
    }

    public static List<Integer> getSquares(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }
}