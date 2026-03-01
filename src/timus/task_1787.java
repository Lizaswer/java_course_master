package timus;

import java.util.Scanner;

public class task_1787 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();

        int trafficJam = 0;

        for (int minute = 0; minute < n; minute++) {
            int arrived = scan.nextInt();

            trafficJam += arrived;
            int passed = Math.min(trafficJam, k);
            trafficJam -= passed;
            }

        System.out.println(trafficJam);

    }
}
