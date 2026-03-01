package lrl1;

import java.util.Scanner;

public class Example9 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите месяц: ");
        String month = scan.nextLine();
        System.out.println("Количество дней в месяце: ");
        int in_month_day = scan.nextInt();

        System.out.println("Месяц: " + month + ", содержит " + in_month_day + " дней/дня/день.");

    }
}
