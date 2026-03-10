package lrl2.timus;

import java.util.Scanner;

public class task_1820 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int minutes;

        if (n <= k) {
            minutes = 2; // нужно прожарить две стороны
        } else {
            minutes = (2 * n + k - 1) / k; // округление вверх

            if (minutes < 2) {
                minutes = 2;
            }
        }

        System.out.println(minutes);
        scanner.close();
    }
}