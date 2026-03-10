package lrl2.class2;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(5, 3);
        Rectangle rect2 = new Rectangle(7.5, 4.2);


        System.out.println("Прямоугольник 1:");
        rect1.displayInfo();

        System.out.println("\nПрямоугольник 2:");
        rect2.displayInfo();


        System.out.println("\n--- Используем геттеры ---");
        System.out.println("Длина rect1: " + rect1.getLength());
        System.out.println("Ширина rect1: " + rect1.getWidth());
        System.out.println("Площадь rect1: " + rect1.calculateArea());
        System.out.println("Периметр rect1: " + rect1.calculatePerimeter());


        System.out.println("\n--- Изменяем размеры через сеттеры ---");
        rect1.setLength(10);
        rect1.setWidth(6);

        System.out.println("Обновленная информация о rect1:");
        rect1.displayInfo();


        System.out.println("\n--- Сравнение прямоугольников ---");
        if (rect1.calculateArea() > rect2.calculateArea()) {
            System.out.println("Прямоугольник 1 больше по площади");
        } else if (rect1.calculateArea() < rect2.calculateArea()) {
            System.out.println("Прямоугольник 2 больше по площади");
        } else {
            System.out.println("Прямоугольники равны по площади");
        }
    }
}


