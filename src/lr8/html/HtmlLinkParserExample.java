package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class HtmlLinkParserExample {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://itlearn.ru/first-steps").get();
            Elements links = doc.select("a[href]");

            System.out.println("=== НАЙДЕННЫЕ ССЫЛКИ ===");
            int count = 0;
            for (Element link : links) {
                String url = link.attr("abs:href");
                String text = link.text();
                if (!text.isEmpty()) {
                    count++;
                    System.out.println(count + ". " + text);
                    System.out.println("   → " + url);
                }
            }
            System.out.println("\n✅ Всего найдено ссылок: " + count);

        } catch (IOException e) {
            System.err.println("❌ Ошибка подключения: " + e.getMessage());
        }
    }
}
