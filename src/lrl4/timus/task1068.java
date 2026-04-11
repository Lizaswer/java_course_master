package lrl4.timus;

import java.util.Scanner;

public class task1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum;

        if (n > 0) {
            sum = n * (n + 1) / 2;
        } else {
            sum = (Math.abs(n) + 2) * (Math.abs(n) + 1) / 2;
            sum = -sum + 1;
        }

        System.out.println(sum);
        scanner.close();
    }
}
