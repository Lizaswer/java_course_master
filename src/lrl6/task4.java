package lrl6;

public class task4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int num = i;
            new Thread(() -> System.out.println("Я поток №" + num)).start();
        }
    }
}


