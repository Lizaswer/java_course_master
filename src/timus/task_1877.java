package timus;

import java.util.Scanner;

public class task_1877 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLock = scanner.nextLine().trim();
        String secondLock = scanner.nextLine().trim();

        int firstCode = Integer.parseInt(firstLock);
        int secondCode = Integer.parseInt(secondLock);

        for (int night = 1; night <= 10000; night++) {
            int tryCode = night - 1;

            if (tryCode > 9999) break;
            int lockUsed = (night % 2 == 1) ? firstCode : secondCode;

            if (tryCode == lockUsed) {
                System.out.println("yes");
                return;
                }
            }

        System.out.println("no");

    }
}
