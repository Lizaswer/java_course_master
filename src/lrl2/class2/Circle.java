package lrl2.class2;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Круг: радиус = " + radius);
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Длина окружности: " + String.format("%.2f", calculatePerimeter()));
    }
}