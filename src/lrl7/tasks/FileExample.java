package lrl7.tasks;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        File folder = new File("src/lr8/example1/example_folder");
        File file = new File(folder, "example_file.txt");

        if (!folder.exists()) {
            folder.mkdirs();
            System.out.println("Папка создана");
        }

        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) {
            System.out.println("Файл удалён");
        }
        if (folder.delete()) {
            System.out.println("Папка удалена");
        }
    }
}