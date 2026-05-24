package lrl7.tasks.console_modified;

import java.io.*;
import java.util.Scanner;

public class ConsoleCharStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("console_char.txt");

        System.out.println("=== Символьный поток с вводом из консоли ===");
        System.out.print("Введите текст: ");
        String userInput = scanner.nextLine();

        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)) {

            fw.write(userInput);
            System.out.println("✓ Записано " + userInput.length() + " символов");

            char[] buffer = new char[(int) file.length()];
            fr.read(buffer);
            System.out.println("✓ Прочитано: " + new String(buffer));

        } catch (IOException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}