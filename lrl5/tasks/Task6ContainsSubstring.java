package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task6ContainsSubstring {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "grape", "apricot", "cherry");
        String substr = "ap";
        List<String> result = filterBySubstring(strings, substr);
        System.out.println("Содержат '" + substr + "': " + result);
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
