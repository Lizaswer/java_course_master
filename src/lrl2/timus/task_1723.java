package lrl2.timus;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class task_1723 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String spell = scanner.nextLine();

        Map<String, Integer> substringCount = new HashMap<>();

        for (int i = 0; i < spell.length(); i++) {
            for (int j = i + 1; j <= spell.length(); j++) {
                String sub = spell.substring(i, j);
                substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
            }
        }

        String strongestSpell = "";
        int maxPower = 0;

        for (Map.Entry<String, Integer> entry : substringCount.entrySet()) {
            if (entry.getValue() > maxPower) {
                maxPower = entry.getValue();
                strongestSpell = entry.getKey();
            }
        }

        System.out.println(strongestSpell);
        scanner.close();
    }
}