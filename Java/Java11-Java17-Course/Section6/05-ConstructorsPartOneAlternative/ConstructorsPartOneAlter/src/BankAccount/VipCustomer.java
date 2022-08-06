package BankAccount;

public class VipCustomer {
    private String customerName;
    private int creditLimit;
    private String customerEmailAddress;

    // initialize and create object
    public VipCustomer() {
        this("Default Name", 10000, "default@email.com");
        System.out.println("Empty constructor called. Assigning default values");
    }

    public VipCustomer(String customerName, String customerEmailAddress) {
        this(customerName, 10000, customerEmailAddress);
    }

    // Major constructor
    public VipCustomer(String customerName, int creditLimit, String customerEmailAddress) {
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.customerEmailAddress = customerEmailAddress;
    }

    // getters
    public String getCustomerName() {
        System.out.println(this.customerName);
        return(this.customerName);
    }

    public int getCreditLimit() {
        System.out.println(this.creditLimit);
        return(this.creditLimit);
    }

    public String getCustomerEmailAddress() {
        System.out.println(this.customerEmailAddress);
        return(this.customerEmailAddress);
    }


}
