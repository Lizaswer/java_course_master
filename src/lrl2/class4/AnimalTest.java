package lrl2.class4;

public class AnimalTest {
    public static void main(String[] args) {
        System.out.println("🐾 ЗООПАРК: НАСЛЕДОВАНИЕ В ДЕЙСТВИИ 🐾");

        Dog dog = new Dog("Рекс", 3, "коричневый", "Овчарка", true);
        Cat cat = new Cat("Мурка", 2, "рыжий", true, "рыба");
        Bird bird = new Bird("Кеша", 1, "зеленый", true, 25.5);
        Bird penguin = new Bird("Пингви", 5, "черно-белый", false, 0);

        System.out.println("🐕 СОБАКА:");
        dog.displayInfo();
        dog.makeSound();
        dog.bringStick();

        System.out.println("\n😺 КОШКА:");
        cat.displayInfo();
        cat.makeSound();
        cat.purr();

        System.out.println("\n🐦 ПТИЦА (попугай):");
        bird.displayInfo();
        bird.makeSound();
        bird.fly();

        System.out.println("\n🐧 ПТИЦА (пингвин):");
        penguin.displayInfo();
        penguin.makeSound();
        penguin.fly();


        System.out.println("\n🔄 ПОЛИМОРФИЗМ: Все животные издают звуки");
        Animal[] animals = {dog, cat, bird, penguin};

        for (int i = 0; i < animals.length; i++) {
            System.out.print("Животное " + (i + 1) + ": ");
            animals[i].makeSound();
        }


        System.out.println("\n СПИСОК ВСЕХ ЖИВОТНЫХ:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")");
        }
    }
}