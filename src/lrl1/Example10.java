package lrl1;

import java.util.Scanner;
import java.time.Year;

public class Example10 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите год рождения: ");
        int birth_year = scan.nextInt();

        int current_year = Year.now().getValue();
        int age = current_year - birth_year;

        System.out.println("Вам " + age + " лет(года).");


    }
}
