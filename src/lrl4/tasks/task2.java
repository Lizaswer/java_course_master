package lrl4.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);
        int columnNumber = -1;

        while (true) {
            try {
                System.out.print("Введите номер столбца (от 0 до " + (matrix[0].length - 1) + "): ");
                columnNumber = scanner.nextInt();

                if (columnNumber < 0 || columnNumber >= matrix[0].length) {
                    throw new ArrayIndexOutOfBoundsException("Столбца с номером " + columnNumber + " не существует.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введена строка вместо числа. Повторите ввод.");
                scanner.next(); // очистка буфера
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        System.out.println("Столбец " + columnNumber + ":");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("matrix[" + i + "][" + columnNumber + "] = " + matrix[i][columnNumber]);
        }

        scanner.close();
    }
}