package lr7.tasks;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StreamConverterExample {
    public static void main(String[] args) {
        String inputFile = "src/resources/input.txt";
        String outputFile = "src/resources/output.txt";

        // Проверяем и создаём input.txt если его нет
        File input = new File(inputFile);
        if (!input.exists()) {
            input.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(input, StandardCharsets.UTF_8)) {
                writer.write("Hello World!\nJava Programming\nUTF-8 Encoding Example");
                System.out.println("Создан пример файла: " + inputFile);
            } catch (IOException e) {
                System.err.println("Не удалось создать файл: " + e.getMessage());
                return;
            }
        }

        // Читаем и преобразуем
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {

            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                String upperLine = line.toUpperCase();
                bw.write(upperLine);
                bw.newLine();
                lineCount++;
                System.out.println("Строка " + lineCount + ": " + line + " -> " + upperLine);
            }

            System.out.println("\nГотово! Обработано " + lineCount + " строк.");
            System.out.println("Результат сохранён в: " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
            e.printStackTrace();
        }
    }
}