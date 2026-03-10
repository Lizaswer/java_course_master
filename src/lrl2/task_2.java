package lrl2;

import java.util.Scanner;

public class task_2 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите количество строк: ");
        int rows = input.nextInt();

        System.out.println("Введите количество столбцов: ");
        int cols = input.nextInt();

        int [][] array = new int[rows][cols];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = value++;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    array[i][j] = value++;
                }
            }
        }

        System.out.println("Заполненный массив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", array[i][j]);
            }
            System.out.println();
        }
    }
}
