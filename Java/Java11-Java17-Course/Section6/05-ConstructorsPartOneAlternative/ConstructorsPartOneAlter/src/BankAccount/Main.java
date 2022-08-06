package BankAccount;

public class Main {
    public static void main(String args[]) {
        Account georgeAccount = new Account("00045419", 1000.00, "George Butter");
        georgeAccount.getBalance();
        georgeAccount.deposit(500.4555);
        georgeAccount.getCustomerName();

        Account benAccount = new Account("Ben", "ben@gmail.com", "0167993915");
        benAccount.getBalance();
        benAccount.getCustomerName();
    }
}
