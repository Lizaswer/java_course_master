package lrl1;

import java.util.Scanner;

public class Example13 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int first_number = scan.nextInt();
        System.out.println("Введите второе число: ");
        int second_number = scan.nextInt();

        int number_sum = first_number + second_number;

        System.out.println("Сумма двух чисел равна: " + number_sum);
    }

}
