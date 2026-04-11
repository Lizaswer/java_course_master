package lrl4.tasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] array = null;
        int size = 0;

        while (true) {
            try {
                System.out.print("Введите размер массива: ");
                size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Размер должен быть положительным числом.");
                    continue;
                }
                array = new byte[size];
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введена строка вместо числа.");
                scanner.next();
            }
        }

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("array[" + i + "] (от -128 до 127): ");
                    int inputValue = scanner.nextInt();

                    if (inputValue < Byte.MIN_VALUE || inputValue > Byte.MAX_VALUE) {
                        throw new Exception("Значение " + inputValue + " выходит за границы типа byte (диапазон от -128 до 127).");
                    }

                    array[i] = (byte) inputValue;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: введена строка вместо числа.");
                    scanner.next();
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        int sum = 0;
        boolean overflow = false;

        for (byte value : array) {
            if (sum > 0 && value > Byte.MAX_VALUE - sum) {
                overflow = true;
            }
            if (sum < 0 && value < Byte.MIN_VALUE - sum) {
                overflow = true;
            }
            sum += value;
        }

        System.out.println("Массив: ");
        for (byte value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        if (overflow) {
            System.out.println("Внимание: при сложении произошло переполнение. Сумма может быть некорректной.");
        }

        try {
            if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
                throw new Exception("Сумма " + sum + " выходит за границы типа byte.");
            }
            System.out.println("Сумма элементов (int): " + sum);
            System.out.println("Сумма элементов (byte): " + (byte) sum);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Сумма в виде int: " + sum);
        }

        scanner.close();
    }
}