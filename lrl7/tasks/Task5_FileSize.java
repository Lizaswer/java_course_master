package lrl7.tasks;

import java.io.File;
import java.util.Scanner;

public class Task5_FileSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();

        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            System.out.printf("Размер файла: %,d байт%n", bytes);

            // Дополнительный вывод в других единицах
            if (bytes >= 1024) {
                System.out.printf("  = %.2f КБ%n", bytes / 1024.0);
            }
            if (bytes >= 1024 * 1024) {
                System.out.printf("  = %.2f МБ%n", bytes / (1024.0 * 1024));
            }
        } else {
            System.out.println("Файл не найден: " + filename);
        }
        scanner.close();
    }
}
