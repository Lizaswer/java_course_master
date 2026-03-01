package lrl1;

import java.util.Scanner;
import java.time.Year;

public class Example12 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваш возраст: ");
        int age = scan.nextInt();

        int current_year = Year.now().getValue();
        int birth_year = current_year - age;

        System.out.println("Ваш год рождения: " + birth_year);
    }

}
