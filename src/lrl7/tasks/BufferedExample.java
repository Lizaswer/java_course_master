package lrl7.tasks;

import java.io.*;

public class BufferedExample {
    public static void main(String[] args) {
        String data = "Буферизированный ввод/вывод";
        File file = new File("example_file.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
             BufferedReader br = new BufferedReader(new FileReader(file))) {

            bw.write(data);
            bw.newLine();
            bw.write("Вторая строка");
            bw.flush();

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
    }
}