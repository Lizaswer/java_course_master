package lrl6;

public class task3 {
    private static int number = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread even = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 == 0) {
                        System.out.println("Even: " + number++);
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });
        Thread odd = new Thread(() -> {
            synchronized (lock) {
                while (number <= 10) {
                    if (number % 2 != 0) {
                        System.out.println("Odd: " + number++);
                        lock.notifyAll();
                    } else {
                        try { lock.wait(); } catch (InterruptedException e) {}
                    }
                }
            }
        });
        even.start(); odd.start();
    }
}

