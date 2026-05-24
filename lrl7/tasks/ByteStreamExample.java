package lrl7.tasks;

import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) {
        String data = "Пример байтового ввода/вывода";
        File file = new File("example_file.txt");

        try (FileOutputStream fos = new FileOutputStream(file);
             FileInputStream fis = new FileInputStream(file)) {

            fos.write(data.getBytes());
            System.out.println("Данные записаны");

            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);
            System.out.println("Прочитано: " + new String(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }

        file.delete();
    }
}