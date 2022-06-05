public class Main {

    public static void main(String[] args) {
        System.out.println("$10,000 at 2% interest for 1 year = " + calculateInterest(10000.0, 2.0));
        System.out.println("$10,000 at 3% interest for 1 year = " + calculateInterest(10000.0, 3.0));
        System.out.println("$10,000 at 4% interest for 1 year = " + calculateInterest(10000.0, 4.0));
        System.out.println("$10,000 at 5% interest for 1 year = " + calculateInterest(10000.0, 5.0));

        double startingAmount = 10000.0;
        double interestRate = 5.0;
        double currentValue = startingAmount;
        System.out.println("Initial Value: $" + currentValue);
        System.out.println("Interest Rate: " + interestRate + "%");

        // for(init; termination; increment) { } i++ -> i = i+1 and i-- -> i = i-1
        for(int i=0; i<=9; i++) {
            double yearInterest = calculateInterest(currentValue, interestRate);
            System.out.println("Interest: $" + String.format("%.2f", yearInterest) + " after year " + (i+1));
            currentValue = currentValue + yearInterest;
            System.out.println("Value: $" + String.format("%.2f", currentValue) + " after year " + (i+1));
        }

        System.out.println("Total Gain: " + String.format("%.2f", ((currentValue/startingAmount)-1)*100) + "%");

        // iterating backwards
        System.out.println("===== countdown 10 to 0 ======");
        for(int i=10; i>=0; i--) {
            System.out.println(i);
        }

        // prime number finder
        System.out.println("===== prime number finder ======");
        int count = 0;
        for(int i=0; i <= 400; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
            if (count == 25) {
                break;
            }
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate/100));
    }

    public static boolean isPrime(int n) {
        if(n<=0 || n==1) {
            return false;
        }
        for (int i=2; i<=n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
