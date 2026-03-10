package lrl2.class5;

public class ShapeTest {
    public static void main(String[] args) {
        System.out.println(" ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ: НАСЛЕДОВАНИЕ В ДЕЙСТВИИ ");

        Circle circle = new Circle("красный", 5);
        Square square = new Square("синий", 4);
        Triangle triangle = new Triangle("зеленый", 3, 4, 5);

        System.out.println("⭕ КРУГ:");
        circle.displayInfo();
        System.out.println("  Диаметр: " + String.format("%.2f", circle.calculateDiameter()));

        System.out.println("\n🔲 КВАДРАТ:");
        square.displayInfo();
        System.out.println("  Диагональ: " + String.format("%.2f", square.calculateDiagonal()));

        System.out.println("\n🔺 ТРЕУГОЛЬНИК:");
        triangle.displayInfo();
        System.out.println("  Прямоугольный: " + (triangle.isRightAngled() ? "Да" : "Нет"));
        System.out.println("  Равносторонний: " + (triangle.isEquilateral() ? "Да" : "Нет"));

        System.out.println("\n🔄 ПОЛИМОРФИЗМ: Все фигуры через один тип Shape");
        Shape[] shapes = {circle, square, triangle};

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\nФигура " + (i + 1) + ":");
            shapes[i].displayInfo();
        }

        System.out.println("\n📊 СРАВНЕНИЕ ПЛОЩАДЕЙ:");
        for (Shape shape : shapes) {
            System.out.println("  " + shape.getClass().getSimpleName() +
                    ": " + String.format("%.2f", shape.calculateArea()));
        }

        System.out.println("\n🎨 ИЗМЕНЕНИЕ ЦВЕТОВ:");
        circle.setColor("оранжевый");
        square.setColor("фиолетовый");
        triangle.setColor("желтый");

        for (Shape shape : shapes) {
            System.out.println("  " + shape.getClass().getSimpleName() +
                    " теперь " + shape.getColor());
        }
    }
}
