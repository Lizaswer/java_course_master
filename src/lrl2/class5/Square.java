package lrl2.class5;

public class Square extends Shape {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;  // a²
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;  // 4a
    }

    @Override
    public void displayInfo() {
        System.out.println("=== КВАДРАТ ===");
        System.out.println("Сторона: " + side);
        super.displayInfo();
    }

    public double calculateDiagonal() {
        return side * Math.sqrt(2);  // a × √2
    }
}
