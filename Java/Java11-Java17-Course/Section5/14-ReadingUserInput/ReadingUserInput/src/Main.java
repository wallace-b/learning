import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner method, reads user input for String

        System.out.println("Enter your year of birth: ");

        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle next line character (enter key)
            int age = 2022 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();
                
                System.out.println("Your name is: " + name);
                System.out.println("Your age is: " + age);
            } else {
                System.out.println("Invalid year of birth entered.");
            }
        } else {
            System.out.println("Unable to parse year of birth.");
        }

        scanner.close();
    }

}
