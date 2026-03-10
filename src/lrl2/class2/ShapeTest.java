package lrl2.class2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 4, 5);

        circle.displayInfo();
        System.out.println();
        square.displayInfo();
        System.out.println();
        triangle.displayInfo();
    }
}
