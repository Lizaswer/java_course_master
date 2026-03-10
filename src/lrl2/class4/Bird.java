package lrl2.class4;

public class Bird extends Animal {
    private boolean canFly;
    private double wingSpan;

    public Bird(String name, int age, String color, boolean canFly, double wingSpan) {
        super(name, age, color);
        this.canFly = canFly;
        this.wingSpan = wingSpan;
    }


    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Чирик-чирик! 🐦");
    }

    public void fly() {
        if (canFly) {
            System.out.println(name + " летит! Размах крыльев: " + wingSpan + " см");
        } else {
            System.out.println(name + " не умеет летать :(");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Умеет летать: " + (canFly ? "Да" : "Нет"));
        System.out.println("Размах крыльев: " + wingSpan + " см");
    }
}