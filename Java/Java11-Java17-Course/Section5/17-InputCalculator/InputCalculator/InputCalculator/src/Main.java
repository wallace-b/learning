import java.util.Scanner;

public class Main {
    public static void inputThenPrintSumAndAverage(){
        int count = 0;
        int sum = 0;
        long average = 0;
        boolean hasNextInt = false;
        int number = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                number = scanner.nextInt();
                scanner.nextLine();

                sum += number;
                count++;
            } else {
                scanner.nextLine();
                break;
            }
        }

        if (count > 0) {
            double sumAsDouble = sum;
            double countAsDouble = count;
            average = Math.round(sumAsDouble/countAsDouble);

        }
        System.out.print("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }
}
