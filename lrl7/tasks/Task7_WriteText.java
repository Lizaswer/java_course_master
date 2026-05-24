package lrl7.tasks;

import java.io.*;
import java.util.Scanner;

public class Task7_WriteText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        System.out.print("Введите текст для записи: ");
        String text = scanner.nextLine();

        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(text);
            int charCount = text.length();
            System.out.println("Записано символов: " + charCount);

            // Проверка: читаем и выводим
            System.out.println("\n--- Проверка содержимого ---");
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                System.out.println(br.readLine());
            }

        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
        scanner.close();
    }
}
