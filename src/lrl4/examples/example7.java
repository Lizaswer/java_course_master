package lrl4.examples;

public class example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException ex) {   // <- ДОБАВЛЕНО
                System.out.println("Перехвачено второе исключение");
            }
        }
        System.out.println("3");
    }
}