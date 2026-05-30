package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class JsonParserComplete {
    private static final String FILE_PATH = "src/Ir8/recources/books.json";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        createInitialJson();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("         JSON ПАРСЕР - МЕНЮ");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить новую книгу");
            System.out.println("3. Поиск книг по автору");
            System.out.println("4. Удалить книгу по названию");
            System.out.println("5. Выход");
            System.out.print("\nВыберите действие (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllBooks();
                case 2 -> addBook(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> deleteBookByTitle(scanner);
                case 5 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void createInitialJson() {
        java.io.File file = new java.io.File(FILE_PATH);
        if (file.exists()) return;

        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        String[][] defaultBooks = {
                {"Java Programming", "John Doe", "2015"},
                {"Python Programming", "Jane Smith", "2018"},
                {"Clean Code", "Robert Martin", "2008"}
        };

        for (String[] bookData : defaultBooks) {
            JSONObject book = new JSONObject();
            book.put("title", bookData[0]);
            book.put("author", bookData[1]);
            book.put("year", bookData[2]);
            books.add(book);
        }

        library.put("books", books);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(library.toJSONString());
            System.out.println("✅ Создан файл books.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject loadJson() throws Exception {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static void saveJson(JSONObject jsonObject) throws Exception {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(jsonObject.toJSONString());
        }
    }

    private static void showAllBooks() {
        try {
            JSONObject jsonObject = loadJson();
            JSONArray books = (JSONArray) jsonObject.get("books");

            if (books.isEmpty()) {
                System.out.println("Библиотека пуста.");
                return;
            }

            System.out.println("\n=== СПИСОК ВСЕХ КНИГ ===");
            for (int i = 0; i < books.size(); i++) {
                JSONObject book = (JSONObject) books.get(i);
                System.out.printf("%d. \"%s\"%n", i + 1, book.get("title"));
                System.out.printf("   Автор: %s%n", book.get("author"));
                System.out.printf("   Год: %s%n", book.get("year"));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void addBook(Scanner scanner) {
        try {
            System.out.print("Название книги: ");
            String title = scanner.nextLine();
            System.out.print("Автор: ");
            String author = scanner.nextLine();
            System.out.print("Год издания: ");
            String year = scanner.nextLine();

            JSONObject jsonObject = loadJson();
            JSONArray books = (JSONArray) jsonObject.get("books");

            JSONObject newBook = new JSONObject();
            newBook.put("title", title);
            newBook.put("author", author);
            newBook.put("year", year);

            books.add(newBook);
            saveJson(jsonObject);

            System.out.println("Книга \"" + title + "\" добавлена!");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void searchByAuthor(Scanner scanner) {
        try {
            System.out.print("Введите автора: ");
            String searchAuthor = scanner.nextLine();

            JSONObject jsonObject = loadJson();
            JSONArray books = (JSONArray) jsonObject.get("books");

            boolean found = false;
            System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");

            for (Object obj : books) {
                JSONObject book = (JSONObject) obj;
                if (book.get("author").toString().equalsIgnoreCase(searchAuthor)) {
                    System.out.printf("\"%s\" (%s)%n", book.get("title"), book.get("year"));
                    found = true;
                }
            }
            if (!found) System.out.println("Книги не найдены.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void deleteBookByTitle(Scanner scanner) {
        try {
            System.out.print("Введите название книги для удаления: ");
            String deleteTitle = scanner.nextLine();

            JSONObject jsonObject = loadJson();
            JSONArray books = (JSONArray) jsonObject.get("books");

            Iterator<Object> iterator = books.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                JSONObject book = (JSONObject) iterator.next();
                if (book.get("title").toString().equalsIgnoreCase(deleteTitle)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Книга не найдена.");
                return;
            }

            saveJson(jsonObject);
            System.out.println("Книга \"" + deleteTitle + "\" удалена.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}