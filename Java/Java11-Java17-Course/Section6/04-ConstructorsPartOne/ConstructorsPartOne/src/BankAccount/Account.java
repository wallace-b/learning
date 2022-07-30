package BankAccount;

import java.text.DecimalFormat;

public class Account {

    private static final DecimalFormat dFormat = new DecimalFormat("#.##");
    private String accountNumber;
    private double balance;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;

    public void setAccountNumber(String accNumber) {
        this.accountNumber = accNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setBalance(double balAmount) {
        this.balance = balAmount;
    }

    public double getBalance() {
        return this.balance;
    }
    public void setCustomerName(String custName) {
        this.customerName = custName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void deposit(double depAmount) {
        System.out.println("previous balance is: $" + this.balance);
        this.balance = Math.round((this.balance + depAmount)*100)/100.0;
        System.out.println("you have deposited: $" + depAmount);
        System.out.println("current balance is: $" + this.balance);
    }

    public void withdraw(double withAmount) {
        if (this.balance < withAmount) {
            System.out.println("current balance is: " + this.balance);
            System.out.println("you are attempting to withdraw: $" + withAmount);
            System.out.println("but have insufficient funds.");
        } else {
            System.out.println("previous balance is: $" + this.balance);
            this.balance = Math.round((this.balance - withAmount)*100)/100.0;
            System.out.println("you have withdrawn: $" + withAmount);
            System.out.println("current balance is: $" + this.balance);
        }

    }
}
