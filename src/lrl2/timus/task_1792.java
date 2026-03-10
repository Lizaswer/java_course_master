package lrl2.timus;

import java.util.Scanner;

public class task_1792 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bits = new int[7];
        for (int i = 0; i < 7; i++) {
            bits[i] = scanner.nextInt();
        }

        int p1 = (bits[0] + bits[1] + bits[3]) % 2; // 1-й круг (1, 2, 4)
        int p2 = (bits[0] + bits[2] + bits[3]) % 2; // 2-й круг (1, 3, 4)
        int p3 = (bits[1] + bits[2] + bits[3]) % 2; // 3-й круг (2, 3, 4)

        int errorPos = 0;

        if (p1 != bits[4]) errorPos += 1;
        if (p2 != bits[5]) errorPos += 2;
        if (p3 != bits[6]) errorPos += 4;


        if (errorPos != 0) {
            bits[errorPos - 1] = (bits[errorPos - 1] + 1) % 2;
        }

        for (int i = 0; i < 7; i++) {
            System.out.print(bits[i]);
            if (i < 6) System.out.print(" ");
        }
        System.out.println();

        scanner.close();
    }
}