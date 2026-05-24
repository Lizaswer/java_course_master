package lrl7.tasks;

import java.io.*;
import java.util.Scanner;

public class Task6_SearchWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            int foundCount = 0;

            System.out.println("\n=== Результаты поиска '" + searchWord + "' ===");

            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("Строка " + lineNum + ": " + line);
                    foundCount++;
                }
            }

            if (foundCount == 0) {
                System.out.println("Слово '" + searchWord + "' не найдено");
            } else {
                System.out.println("\nВсего найдено: " + foundCount + " строк");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        scanner.close();
    }
}