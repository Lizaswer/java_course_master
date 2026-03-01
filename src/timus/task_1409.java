package timus;

import java.util.Scanner;

public class task_1409 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int harryShot = scan.nextInt();
        int larryShot = scan.nextInt();

        int totalCans = harryShot + larryShot - 1;

        int harryMissed = totalCans - harryShot;

        int larryMissed = totalCans - larryShot;

        System.out.println(harryMissed + " " + larryMissed);
    }
}
