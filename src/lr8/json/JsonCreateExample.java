package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class JsonCreateExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Java Programming");
        book1.put("author", "John Doe");
        book1.put("year", "2015");
        books.add(book1);

        JSONObject book2 = new JSONObject();
        book2.put("title", "Python Programming");
        book2.put("author", "Jane Smith");
        book2.put("year", "2018");
        books.add(book2);

        library.put("books", books);

        try (FileWriter file = new FileWriter("src/Ir8/recources/books.json")) {
            file.write(library.toJSONString());
            System.out.println("✅ JSON файл создан: src/Ir8/recources/books.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}