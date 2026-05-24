package lrl7.tasks.console_modified;

import java.io.*;
import java.util.Scanner;

public class ConsoleByteStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("console_byte.txt");

        System.out.println("=== Байтовый поток с вводом из консоли ===");
        System.out.print("Введите текст для записи в файл: ");
        String userInput = scanner.nextLine();

        // Запись
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(userInput.getBytes("UTF-8"));
            System.out.println("✓ Записано " + userInput.getBytes().length + " байт");
        } catch (IOException e) {
            System.out.println("✗ Ошибка записи: " + e.getMessage());
        }

        // Чтение
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);
            System.out.println("✓ Прочитано: " + new String(buffer, "UTF-8"));
        } catch (IOException e) {
            System.out.println("✗ Ошибка чтения: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}
