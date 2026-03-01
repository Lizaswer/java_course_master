package lrl1;

import java.util.Scanner;

public class Example7 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println("Введите возраст: ");
        int age = scan.nextInt();

        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);

    }

}
