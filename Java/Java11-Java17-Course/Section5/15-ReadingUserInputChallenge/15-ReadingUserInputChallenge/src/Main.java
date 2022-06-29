import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner method, reads user input for String

        System.out.println("Enter a number between 2 to 15, inclusive :");

        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int countMax = scanner.nextInt();
            scanner.nextLine(); // handle next line character (enter key)

            int sum = 0;

            if (countMax >= 2 && countMax <= 15) {

                int count = 0; // counter var at 0;
                while (true) { // while (true) -or- while (count <= countMax)
                    System.out.println("Enter a valid number for number #" + (count+1)+ ":");
                    hasNextInt = scanner.hasNextInt();

                    if (hasNextInt) {
                        sum += scanner.nextInt();
                        count++; // once a number is added/summed, the counter is incremented by 1
                    } else {
                        System.out.println("Please re-enter a valid number.");
                    }

                    if (count == countMax) {
                        break;
                    }

                    scanner.nextLine();
                }
                System.out.println("Sum of " + countMax + " numbers is: " + sum);
            } else {
                System.out.println("Invalid amount of numbers to sum.");
            }
        } else {
            System.out.println("Unable to parse amount of numbers to sum.");
        }

        scanner.close();
    }

}