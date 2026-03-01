package lrl1;

import java.util.Scanner;

public class Example14 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scan.nextInt();

        int less_number = number - 1;
        int more_number = number + 1;
        int number_sum = less_number + number + more_number;

        int square_number = number_sum * number_sum;

        System.out.println("Последовательность чисел:");
        System.out.println("1-е число (на 1 меньше): " + less_number);
        System.out.println("2-е число (введенное): " + number);
        System.out.println("3-е число (на 1 больше): " + more_number);
        System.out.println("4-е число (квадрат суммы первых трех): " + square_number);
    }

}
