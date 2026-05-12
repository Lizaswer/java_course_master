package lrl6;

public class task1 {
public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
        long end = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < end) {
            System.out.println(Thread.currentThread().getName() + " - " + new java.util.Date());
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    });
    Thread t2 = new Thread(() -> {
        long end = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < end) {
            System.out.println(Thread.currentThread().getName() + " - " + new java.util.Date());
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    });
    t1.start(); t2.start();
    t1.join(); t2.join();
    }
}
