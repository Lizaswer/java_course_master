package lrl2.class3;

public interface AccountOperations {
    void deposit(double amount);           // внесение денег
    void withdraw(double amount);          // снятие денег
    double getBalance();                   // получение текущего баланса
    void displayAccountInfo();              // вывод информации о счете
}
