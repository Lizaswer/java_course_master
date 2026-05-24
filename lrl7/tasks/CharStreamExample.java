package lrl7.tasks;

import java.io.*;

public class CharStreamExample {
    public static void main(String[] args) {
        String data = "Символьный поток";
        File file = new File("example_file.txt");

        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)) {

            fw.write(data);
            System.out.println("Записано");

            char[] buffer = new char[(int) file.length()];
            fr.read(buffer);
            System.out.println("Прочитано: " + new String(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
    }
}