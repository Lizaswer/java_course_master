package lrl4.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        int size = 0;

        while (true) {
            try {
                System.out.print("Введите размер массива: ");
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Размер должен быть положительным числом. Повторите ввод.");
                    continue;
                }
                array = new int[size];
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введена строка вместо числа. Повторите ввод.");
                scanner.next(); // очистка буфера
            }
        }

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("array[" + i + "] = ");
                    array[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа. Введите целое число.");
                    scanner.next(); // очистка буфера
                }
            }
        }

        int sum = 0;
        int positiveCount = 0;

        for (int value : array) {
            if (value > 0) {
                sum += value;
                positiveCount++;
            }
        }

        try {
            if (positiveCount == 0) {
                throw new Exception("Положительные элементы отсутствуют.");
            }
            double average = (double) sum / positiveCount;
            System.out.println("Среднее значение среди положительных элементов: " + average);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}