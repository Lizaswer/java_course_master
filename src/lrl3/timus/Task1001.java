package lrl3.timus;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Task1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> numbers = new ArrayList<>();

        while (sc.hasNextLong()) {
            numbers.add(sc.nextLong());
        }

        Collections.reverse(numbers);

        for (long num : numbers) {
            System.out.printf("%.4f\n", Math.sqrt(num));
        }

        sc.close();
    }
}
