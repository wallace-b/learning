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

        VipCustomer vipJim = new VipCustomer();
        vipJim.getCustomerName();
        vipJim.getCreditLimit();
        vipJim.getCustomerEmailAddress();

        VipCustomer vipTim = new VipCustomer("Tim Black", 15000, "timblack@webmail.com");
        vipTim.getCustomerName();
        vipTim.getCreditLimit();
        vipTim.getCustomerEmailAddress();

        VipCustomer vipLim = new VipCustomer("Lim Blue", "lim351@gmail.com");
        vipLim.getCustomerName();
        vipLim.getCreditLimit();
        vipLim.getCustomerEmailAddress();
    }
}
