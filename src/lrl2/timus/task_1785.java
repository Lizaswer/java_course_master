package lrl2.timus;

import java.util.Scanner;

public class task_1785 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] bounds = {1, 5, 10, 20, 50, 100, 250, 500, 1000};
        String[] words = {"few", "several", "pack", "lots", "horde", "throng", "swarm", "zounds", "legion"};

        String result = "legion";

        for (int i = 0; i < bounds.length; i++) {
            if (n < bounds[i]) {
                result = words[i - 1];
                break;
            }
        }

        System.out.println(result);
        scanner.close();
    }
}
