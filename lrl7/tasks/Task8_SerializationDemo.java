package lrl7.tasks;

import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("  Студент: " + name);
        System.out.println("  ID: " + id);
        System.out.println("  GPA: " + gpa);
    }
}

public class Task8_SerializationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("student.ser");

        System.out.println("=== Сериализация объекта ===");
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();
        System.out.print("Введите ID: ");
        int id = scanner.nextInt();
        System.out.print("Введите GPA: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(name, id, gpa);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(student);
            System.out.println("✓ Объект сохранён в " + file.getName());
        } catch (IOException e) {
            System.out.println("✗ Ошибка сериализации: " + e.getMessage());
            return;
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Student restored = (Student) ois.readObject();
            System.out.println("\n✓ Объект восстановлен из файла:");
            restored.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("✗ Ошибка десериализации: " + e.getMessage());
        }

        file.delete();
        scanner.close();
    }
}