package lrl2.class3;

public class BankAccount implements AccountOperations {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static int totalAccounts = 0;  // счетчик всех созданных счетов


    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.accountHolder = "Не указан";
        this.balance = 0.0;
        totalAccounts++;
    }

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
    }

    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis() + totalAccounts;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }



    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Внесено: " + amount + " руб.");
            System.out.println("   Текущий баланс: " + balance + " руб.");
        } else {
            System.out.println("❌ Ошибка! Сумма должна быть положительной.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Ошибка! Сумма должна быть положительной.");
        } else if (amount > balance) {
            System.out.println("❌ Ошибка! Недостаточно средств.");
            System.out.println("   Доступно: " + balance + " руб.");
        } else {
            balance -= amount;
            System.out.println("✅ Снято: " + amount + " руб.");
            System.out.println("   Текущий баланс: " + balance + " руб.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n=== ИНФОРМАЦИЯ О СЧЕТЕ ===");
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Владелец: " + accountHolder);
        System.out.println("Баланс: " + balance + " руб.");
        System.out.println("===========================");
    }
}
