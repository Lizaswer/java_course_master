package lrl1;

import java.util.Scanner;

public class Example6 {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String surname = scan.nextLine();
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println("Введите отчетво: ");
        String patronymic = scan.nextLine();

        System.out.println("Hello " + " " + surname + " " + name + " " + patronymic);

    }
}
