package BankAccount;

public class Main {

    public static void main(String[] args) {
        Account bradleyAccount = new Account();
        bradleyAccount.setCustomerName("Bradley Smith");
        bradleyAccount.setBalance(10045.55);
        System.out.println(bradleyAccount.getCustomerName());
        System.out.println(bradleyAccount.getBalance());
        bradleyAccount.withdraw(6200.95);
        bradleyAccount.deposit(1500);

    }
}
