package lrl7.tasks;

import java.io.*;
import java.util.Scanner;

public class Task3_CountLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filename = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            long lineCount = br.lines().count();
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден - " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        scanner.close();
    }
}
