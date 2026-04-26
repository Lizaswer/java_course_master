package lrl5.timus;

import java.util.Scanner;

public class Task1327 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        sc.close();

        int count = 0;

        for (int day = A; day <= B; day++) {
            if (day % 2 == 1) { // нечетный день
                count++;
            }
        }

        System.out.println(count);
    }
}
