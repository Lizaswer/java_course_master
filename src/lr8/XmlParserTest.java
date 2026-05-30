package lr8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XmlParserTest {

    @Test
    void testFileExists() {
        java.io.File file = new java.io.File("src/main/resources/library.xml");
        assertTrue(file.exists(), "Файл library.xml должен существовать");
    }

    @Test
    void testFileNotEmpty() {
        java.io.File file = new java.io.File("src/main/resources/library.xml");
        assertTrue(file.length() > 0, "Файл не должен быть пустым");
    }
}
