package lrl5.timus;

import java.util.Scanner;

public class Task1313 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int diag = 0; diag <= 2 * (N - 1); diag++) {
            // Проходим по всем строкам снизу вверх
            for (int i = N - 1; i >= 0; i--) {
                int j = diag - i;
                if (j >= 0 && j < N) {
                    System.out.print(a[i][j] + " ");
                }
            }
        }

        sc.close();
    }
}
