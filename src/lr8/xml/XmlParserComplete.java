package lr8.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XmlParserComplete {
    private static final String FILE_PATH = "src/lr8/recources/library.xml";

    public static void main(String[] args) {
        createInitialXml();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("XML ПАРСЕР - МЕНЮ");
            System.out.println("1. Показать все книги");
            System.out.println("2. Добавить новую книгу");
            System.out.println("3. Поиск книг по автору");
            System.out.println("4. Поиск книг по году");
            System.out.println("5. Удалить книгу по названию");
            System.out.println("6. Выход");
            System.out.print("\nВыберите действие (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllBooks();
                case 2 -> addBook(scanner);
                case 3 -> searchByAuthor(scanner);
                case 4 -> searchByYear(scanner);
                case 5 -> deleteBookByTitle(scanner);
                case 6 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static void createInitialXml() {
        File file = new File(FILE_PATH);
        if (file.exists()) return;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            String[][] defaultBooks = {
                    {"Война и мир", "Лев Толстой", "1869"},
                    {"Мастер и Маргарита", "Михаил Булгаков", "1967"},
                    {"Преступление и наказание", "Фёдор Достоевский", "1866"}
            };

            for (String[] bookData : defaultBooks) {
                Element book = doc.createElement("book");

                Element title = doc.createElement("title");
                title.appendChild(doc.createTextNode(bookData[0]));
                book.appendChild(title);

                Element author = doc.createElement("author");
                author.appendChild(doc.createTextNode(bookData[1]));
                book.appendChild(author);

                Element year = doc.createElement("year");
                year.appendChild(doc.createTextNode(bookData[2]));
                book.appendChild(year);

                rootElement.appendChild(book);
            }

            saveDocument(doc);
            System.out.println("✅ Создан файл library.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveDocument(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static Document loadDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static String getElementText(Element parent, String tagName) {
        NodeList nodes = parent.getElementsByTagName(tagName);
        return nodes.getLength() > 0 ? nodes.item(0).getTextContent() : "";
    }

    private static void showAllBooks() {
        try {
            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");

            if (books.getLength() == 0) {
                System.out.println("Библиотека пуста.");
                return;
            }

            System.out.println("\n=== СПИСОК ВСЕХ КНИГ ===");
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                System.out.printf("%d. \"%s\"%n", i + 1, getElementText(book, "title"));
                System.out.printf("   Автор: %s%n", getElementText(book, "author"));
                System.out.printf("   Год: %s%n", getElementText(book, "year"));
                System.out.println("----------------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void addBook(Scanner scanner) {
        try {
            System.out.print("Название книги: ");
            String title = scanner.nextLine();
            System.out.print("Автор: ");
            String author = scanner.nextLine();
            System.out.print("Год издания: ");
            String year = scanner.nextLine();

            Document doc = loadDocument();
            Element library = doc.getDocumentElement();
            Element book = doc.createElement("book");

            Element titleElem = doc.createElement("title");
            titleElem.setTextContent(title);
            book.appendChild(titleElem);

            Element authorElem = doc.createElement("author");
            authorElem.setTextContent(author);
            book.appendChild(authorElem);

            Element yearElem = doc.createElement("year");
            yearElem.setTextContent(year);
            book.appendChild(yearElem);

            library.appendChild(book);
            saveDocument(doc);

            System.out.println("Книга \"" + title + "\" добавлена!");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void searchByAuthor(Scanner scanner) {
        try {
            System.out.print("Введите автора: ");
            String searchAuthor = scanner.nextLine();

            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");

            boolean found = false;
            System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");

            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                String author = getElementText(book, "author");
                if (author.equalsIgnoreCase(searchAuthor)) {
                    System.out.printf("\"%s\" (%s)%n",
                            getElementText(book, "title"),
                            getElementText(book, "year"));
                    found = true;
                }
            }
            if (!found) System.out.println("Книги не найдены.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static void searchByYear(Scanner scanner) {
        try {
            System.out.print("Введите год: ");
            String searchYear = scanner.nextLine();

            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");

            boolean found = false;
            System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");

            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                String year = getElementText(book, "year");
                if (year.equals(searchYear)) {
                    System.out.printf("\"%s\" - %s%n",
                            getElementText(book, "title"),
                            getElementText(book, "author"));
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

            Document doc = loadDocument();
            NodeList books = doc.getElementsByTagName("book");

            Element bookToDelete = null;
            for (int i = 0; i < books.getLength(); i++) {
                Element book = (Element) books.item(i);
                if (getElementText(book, "title").equalsIgnoreCase(deleteTitle)) {
                    bookToDelete = book;
                    break;
                }
            }

            if (bookToDelete == null) {
                System.out.println("Книга не найдена.");
                return;
            }

            bookToDelete.getParentNode().removeChild(bookToDelete);
            saveDocument(doc);
            System.out.println("Книга \"" + deleteTitle + "\" удалена.");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}