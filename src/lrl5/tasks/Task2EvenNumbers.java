package lrl5.tasks;

import java.util.Arrays;

public class Task2EvenNumbers {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = getEvenNumbers(numbers);
        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Четные числа: " + Arrays.toString(evens));
    }

    public static int[] getEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();
    }
}

