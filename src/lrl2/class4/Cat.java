package lrl2.class4;

public class Cat extends Animal {
    private boolean isIndoor;
    private String favoriteFood;

    public Cat(String name, int age, String color, boolean isIndoor, String favoriteFood) {
        super(name, age, color);
        this.isIndoor = isIndoor;
        this.favoriteFood = favoriteFood;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу-мяу! 🐈");
    }

    public void purr() {
        System.out.println(name + " мурлыкает... 😻");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип: " + (isIndoor ? "Домашняя" : "Уличная"));
        System.out.println("Любимая еда: " + favoriteFood);
    }
}