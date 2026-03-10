import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task_1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = input.nextInt();

        System.out.println("Размер массива равен: " + size);
        int [] nums = new int[size];

        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(200);

            System.out.println("Элемент массива ["+ i +"] = " + nums[i]);
        }

        int minValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }

        System.out.print("Индексы элементов с минимальным значением: ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                System.out.print(i + " ");
            }
        }
    }
}
