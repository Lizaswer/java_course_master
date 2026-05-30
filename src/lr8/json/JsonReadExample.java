package lr8.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReadExample {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/lr8/recources/books.json")) {
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray books = (JSONArray) obj.get("books");

            System.out.println("=== СПИСОК КНИГ ===");
            for (Object bookObj : books) {
                JSONObject book = (JSONObject) bookObj;
                System.out.println("📚 " + book.get("title"));
                System.out.println("   ✍️ " + book.get("author"));
                System.out.println("   📅 " + book.get("year"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}