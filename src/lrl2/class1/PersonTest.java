package lrl2.class1;

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person("Анна", 25, "женский");
        Person person2 = new Person("Иван", 30, "мужской");

        System.out.println("Информация о person1:");
        person1.displayInfo();

        System.out.println("\nИнформация о person2:");
        person2.displayInfo();

        System.out.println("\n--- Используем геттеры ---");
        System.out.println("Имя person1: " + person1.getName());
        System.out.println("Возраст person1: " + person1.getAge());
        System.out.println("Пол person1: " + person1.getGender());

        System.out.println("\n--- Изменяем данные через сеттеры ---");
        person1.setAge(26);
        person1.setName("Анна Петровна");

        System.out.println("Обновленная информация о person1:");
        person1.displayInfo();
    }
}

