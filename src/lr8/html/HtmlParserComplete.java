package lr8.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HtmlParserComplete {
    private static final String URL = "http://fat.urfu.ru/index.html";
    private static final String OUTPUT_FILE = "src/Ir8/recources/news_output.txt";
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {

        System.out.println(" HTML ПАРСЕР НОВОСТЕЙ");

        parseAndSaveNews();
    }

    private static void parseAndSaveNews() {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("\nПопытка " + attempt + " из " + MAX_ATTEMPTS);

            try {
                Document doc = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                        .timeout(10000)
                        .get();

                System.out.println("Страница загружена!");
                saveNewsToFile(doc);
                System.out.println("\nНовости сохранены в " + OUTPUT_FILE);
                return;

            } catch (IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
                if (attempt == MAX_ATTEMPTS) {
                    System.err.println("Не удалось загрузить страницу.");
                } else {
                    System.out.println("Повтор через 3 секунды...");
                    try { Thread.sleep(3000); } catch (InterruptedException ie) {}
                }
            }
        }
    }

    private static void saveNewsToFile(Document doc) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
            writer.println("НОВОСТИ С САЙТА: " + URL);
            writer.println("Дата: " + timestamp);
            writer.println();

            Elements textElements = doc.select("p, div, td");
            int newsCount = 0;

            for (Element element : textElements) {
                String text = element.text().trim();
                if (isNewsText(text) && newsCount < 20) {
                    newsCount++;
                    writer.println("НОВОСТЬ #" + newsCount);
                    writer.println(text);
                    writer.println("----------------------------------------");
                    writer.println();

                    System.out.println("\nНовость #" + newsCount);
                    System.out.println(text.substring(0, Math.min(100, text.length())) + "...");
                }
            }

            writer.println("\nВсего найдено новостей: " + newsCount);
            System.out.println("\nВсего новостей: " + newsCount);

        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
        }
    }

    private static boolean isNewsText(String text) {
        if (text == null || text.isEmpty()) return false;
        if (text.length() < 30) return false;

        String[] exclude = {"©", "карта сайта", "email", "телефон", "поиск"};
        for (String word : exclude) {
            if (text.toLowerCase().contains(word)) return false;
        }
        return true;
    }
}