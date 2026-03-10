package lrl2.class5;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }

    public void setSides(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        // Формула Герона
        double s = calculatePerimeter() / 2;  // полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== ТРЕУГОЛЬНИК ===");
        System.out.println("Стороны: " + sideA + ", " + sideB + ", " + sideC);
        super.displayInfo();
    }

    public boolean isRightAngled() {
        // Проверка теоремы Пифагора
        double[] sides = {sideA, sideB, sideC};
        java.util.Arrays.sort(sides);

        return Math.abs(Math.pow(sides[2], 2) - (Math.pow(sides[0], 2) + Math.pow(sides[1], 2))) < 0.0001;
    }

    public boolean isEquilateral() {
        return (sideA == sideB) && (sideB == sideC);
    }
}