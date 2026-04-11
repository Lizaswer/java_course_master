package lrl4.examples;

public class example6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {      // потомок
            System.out.println("1");
        } catch (RuntimeException e) {          // потомок
            System.out.println("2");
        } catch (Exception e) {                 // предок — в конце
            System.out.println("3");
        }
        System.out.println("4");
    }
}