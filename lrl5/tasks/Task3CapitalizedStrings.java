package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task3CapitalizedStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "python", "C++", "javascript", "Kotlin");
        List<String> result = getCapitalizedStrings(words);
        System.out.println("С большой буквы: " + result);
    }

    public static List<String> getCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
