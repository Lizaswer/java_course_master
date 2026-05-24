package lrl7.tasks.console_modified;

import java.io.*;
import java.util.Scanner;

public class ConsoleBuffered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("console_buffered.txt");

        System.out.println("=== Буферизация с вводом из консоли ===");
        System.out.println("Введите несколько строк (пустая строка - окончание):");

        // Запись с буферизацией
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) break;
                bw.write(line);
                bw.newLine();
            }
            System.out.println("✓ Запись завершена");
        } catch (IOException e) {
            System.out.println("✗ Ошибка записи: " + e.getMessage());
        }

        // Чтение с буферизацией
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("\n--- Содержимое файла ---");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("✗ Ошибка чтения: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}