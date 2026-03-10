package lrl2.class4;

public class Dog extends Animal {

    private String breed;
    private boolean isTrained;

    public Dog(String name, int age, String color, String breed, boolean isTrained) {
        super(name, age, color);
        this.breed = breed;
        this.isTrained = isTrained;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав-гав! 🐕");
    }


    public void bringStick() {
        if (isTrained) {
            System.out.println(name + " принесла палку! 🦴");
        } else {
            System.out.println(name + " не понимает, что вы хотите...");
        }
    }


    @Override
    public void displayInfo() {
        super.displayInfo();  // вызов метода родителя
        System.out.println("Порода: " + breed);
        System.out.println("Дрессирована: " + (isTrained ? "Да" : "Нет"));
    }
}