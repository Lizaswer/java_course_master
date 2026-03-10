package lrl2.class3;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ДОБРО ПОЖАЛОВАТЬ В БАНК!");
        System.out.println("===========================");

        System.out.println("\nСоздание первого счета:");
        System.out.print("Введите имя владельца: ");
        String name1 = scanner.nextLine();
        System.out.print("Введите начальный баланс: ");
        double balance1 = scanner.nextDouble();
        scanner.nextLine();

        BankAccount account1 = new BankAccount(name1, balance1);

        System.out.println("\nСоздание второго счета:");
        System.out.print("Введите имя владельца: ");
        String name2 = scanner.nextLine();
        System.out.print("Введите начальный баланс: ");
        double balance2 = scanner.nextDouble();

        BankAccount account2 = new BankAccount(name2, balance2);


        System.out.println("\n ИНФОРМАЦИЯ О СЧЕТАХ");
        account1.displayAccountInfo();
        account2.displayAccountInfo();


        System.out.println("\n ОПЕРАЦИИ СО СЧЕТОМ " + account1.getAccountHolder());
        System.out.print("Сколько хотите внести? ");
        double depositAmount = scanner.nextDouble();
        account1.deposit(depositAmount);

        System.out.print("Сколько хотите снять? ");
        double withdrawAmount = scanner.nextDouble();
        account1.withdraw(withdrawAmount);


        System.out.println("\n💳 ОПЕРАЦИИ СО СЧЕТОМ " + account2.getAccountHolder());
        System.out.print("Сколько хотите внести? ");
        depositAmount = scanner.nextDouble();
        account2.deposit(depositAmount);

        System.out.print("Сколько хотите снять? ");
        withdrawAmount = scanner.nextDouble();
        account2.withdraw(withdrawAmount);


        System.out.println("\n📊 ИТОГОВАЯ ИНФОРМАЦИЯ");
        account1.displayAccountInfo();
        account2.displayAccountInfo();

        System.out.println("\n📊 Статистика:");
        System.out.println("Всего создано счетов: " + BankAccount.getTotalAccounts());

        scanner.close();
    }
}
