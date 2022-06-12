public class Main {

    public static void main(String args[]) {
        System.out.println("Sum is: " + sumDigits(125));
    }

    public static int sumDigits(int number) {

        if (number < 10) {
            return -1;
        }

        int sum = 0;
        while (number >= 1) {
            System.out.println("Looking at the last digit of: " + number);
            System.out.println("The last single digit is: " + number % 10);
            sum += number % 10;
            number = Math.round(number/10);
        }
        return sum;
    }

}
