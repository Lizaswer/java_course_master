package lrl2.class5;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;  // π × r²
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;  // 2πr (длина окружности)
    }

    @Override
    public void displayInfo() {
        System.out.println("=== КРУГ ===");
        System.out.println("Радиус: " + radius);
        super.displayInfo();  // вызов метода родителя для вывода цвета, площади, периметра
    }

    public double calculateDiameter() {
        return 2 * radius;
    }
}
