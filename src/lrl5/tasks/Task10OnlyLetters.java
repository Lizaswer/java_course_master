package lrl5.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Task10OnlyLetters {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world123", "Java", "C++", "Lambda");
        List<String> result = getOnlyLetters(strings);
        System.out.println("Только буквы: " + result);
    }

    public static List<String> getOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[A-Za-zА-Яа-я]+"))
                .collect(Collectors.toList());
    }
}