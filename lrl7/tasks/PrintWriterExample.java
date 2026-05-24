package lrl7.tasks;

import java.io.*;

public class PrintWriterExample {
    public static void main(String[] args) {
        try (PrintWriter pw = new PrintWriter(new File("printwriter.txt"), "UTF-8")) {
            pw.println("Строка 1");
            pw.printf("Число %d", 123);
            System.out.println("Записано через PrintWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
