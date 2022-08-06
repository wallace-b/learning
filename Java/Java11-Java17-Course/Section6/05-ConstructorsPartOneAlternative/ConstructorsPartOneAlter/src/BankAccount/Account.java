package BankAccount;

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    // initialize and create object
    public Account() {
        System.out.println("Empty constructor called");
    }

    // Major constructor to handle all initialization //
    public Account(String number, double balance, String customerName, String customerEmailAddress,
                   String customerPhoneNumber) {
        this.number = number; // setNumber(number) could be used to call validity checks, but this could be problematic
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        // don't call setters and getters in a constructor, there could be initialization problems
    }
    // ** Call major constructor for method overloading, as below

    public Account(String number, double balance, String customerName) {
        this(number, balance, customerName, "default", "default");
    }

    public Account(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this("999999", 100.00, customerName, customerEmailAddress, customerPhoneNumber);
    }

    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of $" + depositAmount + " received. New balance is $" + Math.round(this.balance*100.00)/100.00);
    }

    public void withdrawal(double withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Insufficient funds. Withdrawal not processed. Only $" +
                    this.balance + " is available");
        } else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of $" + withdrawalAmount + " processed. New balance is $" + Math.round(this.balance*100.00)/100.00);
        }
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        System.out.println(this.number);
        return this.number;
    }

    public void setBalance(double balance) {
        this.balance = Math.round(balance*100.00)/100.00;
    }

    public double getBalance() {
        System.out.println("$" + Math.round(this.balance*100.00)/100.00);
        return this.balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        System.out.println(this.customerName);
        return this.customerName;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerEmailAddress() {
        System.out.println(this.customerEmailAddress);
        return this.customerEmailAddress;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerPhoneNumber() {
        System.out.println(this.customerPhoneNumber);
        return this.customerPhoneNumber;
    }

}
