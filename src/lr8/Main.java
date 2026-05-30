package lr8;

import lr8.xml.XmlParserComplete;
import lr8.json.JsonParserComplete;
import lr8.html.HtmlParserComplete;
import lr8.excel.ExcelParserComplete;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВЫБЕРИТЕ ЗАДАНИЕ:");
            System.out.println("1. XML парсер");
            System.out.println("2. JSON парсер");
            System.out.println("3. HTML парсер");
            System.out.println("4. Excel парсер");
            System.out.println("5. Timus задачи");
            System.out.println("6. Выйти");
            System.out.print("> ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> XmlParserComplete.main(new String[]{});
                case 2 -> JsonParserComplete.main(new String[]{});
                case 3 -> HtmlParserComplete.main(new String[]{});
                case 4 -> ExcelParserComplete.main(new String[]{});
                case 5 -> {
                }
                case 6 -> {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}
