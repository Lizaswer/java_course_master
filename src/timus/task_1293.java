package timus;

import java.util.Scanner;

public class task_1293 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int A = scan.nextInt();
        int B = scan.nextInt();

        int result = N * (A * B) * 2;

        System.out.println(result);
    }
}
