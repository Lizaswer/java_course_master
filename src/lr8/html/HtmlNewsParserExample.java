package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class HtmlNewsParserExample {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://fat.urfu.ru/index.html").get();

            Elements textElements = doc.select("p, div, td");

            System.out.println("=== НОВОСТИ САЙТА ===");
            int newsCount = 0;

            for (Element element : textElements) {
                String text = element.text().trim();
                if (text.length() > 50 && text.length() < 500 && !text.contains("©")) {
                    newsCount++;
                    System.out.println("\n📰 Новость #" + newsCount);
                    System.out.println(text.substring(0, Math.min(150, text.length())) + "...");
                    if (newsCount >= 10) break;
                }
            }

            if (newsCount == 0) {
                System.out.println("Новости не найдены.");
            }

        } catch (IOException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
}