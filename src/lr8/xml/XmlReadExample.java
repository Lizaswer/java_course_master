package lr8.xml;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class XmlReadExample {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/lr8/recources/library.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("book");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = eElement.getElementsByTagName("author").item(0).getTextContent();
                    String year = eElement.getElementsByTagName("year").item(0).getTextContent();

                    System.out.println("\n📚 Книга " + (i+1) + ":");
                    System.out.println("   Название: " + title);
                    System.out.println("   Автор: " + author);
                    System.out.println("   Год: " + year);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}