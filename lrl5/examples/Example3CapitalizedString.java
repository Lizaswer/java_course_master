package lrl5.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3CapitalizedString {
    public static void main(String[] args) {
        String text = "Напишите функцию Которая принимает на вход список Строки и возвращает новый список Содержащий только те строки Которые начинаются с большой буквы";
        List<String> strings = Arrays.asList(text.split(" "));

        System.out.println("Исходный список строк:");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> result = filterCapitalizedStrings(strings);

        System.out.println("\nСтроки, начинающиеся с большой буквы:");
        for (String e : result) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}
