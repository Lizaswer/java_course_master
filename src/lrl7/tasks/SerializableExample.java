package lrl7.tasks;

import java.io.*;

public class SerializableExample {
    public static void main(String[] args) {
        // Сначала создаём объект Person
        Person person = new Person("Иван", 25);  // ← ЭТО БЫЛО ПРОПУЩЕНО!

        // Java САМА создаст файл person.ser здесь
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {  // ← УБРАТЬ "name:"
            oos.writeObject(person);
            System.out.println("✓ Файл person.ser создан автоматически");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение из автоматически созданного файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {  // ← УБРАТЬ "name:"
            Person restored = (Person) ois.readObject();
            restored.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
