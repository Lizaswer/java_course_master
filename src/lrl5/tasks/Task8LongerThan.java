package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task8LongerThan {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "elephant", "dog", "butterfly", "ant");
        int minLength = 4;
        List<String> result = getLongerThan(words, minLength);
        System.out.println("Длиннее " + minLength + ": " + result);
    }

    public static List<String> getLongerThan(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}