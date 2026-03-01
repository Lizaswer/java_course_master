package lrl1;

import java.util.Scanner;

public class Example8 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текущий день недели: ");
        String day = scan.nextLine();
        System.out.println("Введите месяц: ");
        String month = scan.nextLine();
        System.out.println("Введите номер дня в месяце: ");
        int in_month_number_day = scan.nextInt();

        System.out.println("Сегодняшняя дата: " + day + " " + in_month_number_day + " " + month);

    }
}
