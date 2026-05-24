package lrl7.tasks;

import java.io.*;
import java.util.Scanner;

public class Task4_CopyFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к исходному файлу: ");
        String source = scanner.nextLine();
        System.out.print("Введите путь к целевому файлу: ");
        String dest = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {

            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                lineCount++;
            }
            System.out.println("Скопировано " + lineCount + " строк");
            System.out.println("Из: " + source);
            System.out.println("В: " + dest);

        } catch (FileNotFoundException e) {
            System.out.println("Исходный файл не найден: " + source);
        } catch (IOException e) {
            System.out.println("Ошибка копирования: " + e.getMessage());
        }
        scanner.close();
    }
}
