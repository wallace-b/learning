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

        // for(init; termination; increment) { }
        for(int i=0; i<=9; i++) {
            double yearInterest = calculateInterest(currentValue, interestRate);
            System.out.println("Interest: $" + String.format("%.2f", yearInterest) + " after year " + (i+1));
            currentValue = currentValue + yearInterest;
            System.out.println("Value: $" + String.format("%.2f", currentValue) + " after year " + (i+1));
        }

        System.out.println("Total Gain: " + String.format("%.2f", ((currentValue/startingAmount)-1)*100) + "%");

    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate/100));
    }


}
