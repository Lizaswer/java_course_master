package lrl7.tasks.console_modified;

import java.io.*;
import java.util.Scanner;

public class ConsolePrintWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("console_printwriter.txt");

        System.out.println("=== PrintWriter с вводом из консоли ===");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        System.out.print("Введите рост (м): ");
        double height = scanner.nextDouble();

        try (PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {

            pw.printf("Имя: %s%nВозраст: %d%nРост: %.2f м%n", name, age, height);
            System.out.println("✓ Данные записаны в файл");

            // Чтение и вывод
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                System.out.println("\n--- Содержимое файла ---");
                br.lines().forEach(System.out::println);
            }

        } catch (IOException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}
