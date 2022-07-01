import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int min = 0;
        boolean first = true;

        while (true) {
            System.out.println("Enter a number:");

            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();
                scanner.nextLine();

                if (first) {
                    first = false;
                    min = number;
                    max = number;
                }

                if (number > max) {
                    max = number;
                }

                if (number < min) {
                    min = number;
                }

            } else {
                scanner.nextLine();
                System.out.println("Invalid entry, exiting number entry");
                break;
            }

        }

        System.out.println("Min number is: " + min);
        System.out.println("Max number is: " + max);

        scanner.close();





    }


}
