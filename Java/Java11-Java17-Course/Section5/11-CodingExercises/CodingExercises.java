import java.util.Arrays;

public class Main {

    // Print Statements / Testing

    public static void main(String args[]){
        isPerfectNumber(6);
        printDigits(1200);
    }

    // Exercise 16 - First and Last Digit Sum
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        int firstDigit = 0;
        int lastDigit = 0;
        int count = 0;

        while (number > 0) {
            firstDigit = number % 10;
            if (count == 0) {
                lastDigit = number % 10;
            }
            number /= 10;
            count++;
        }

        return firstDigit + lastDigit;

    }

    // Exercise 17 - Even Digit Sum
    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;
        int step = 0;
        while (number > 1) {
            step = number % 10;
            if (step > 1 && (step % 2) == 0) {
                sum += step;
            }
            number /= 10;
        }

        return sum;

    }

    // Exercise 18 - Shared Digit equivalency (10-99 ints)
    public static boolean hasSharedDigit(int numberOne, int numberTwo) {
        if (numberOne < 10 || numberTwo <10 || numberOne > 99 || numberTwo > 99) {
            return false;
        }

        int numOneDigitOne = numberOne % 10;
        int numOneDigitTwo = Math.round(numberOne / 10) % 10;
        int numTwoDigitOne = numberTwo % 10;
        int numTwoDigitTwo = Math.round(numberTwo / 10) % 10;

        if (numOneDigitOne == numTwoDigitOne || numOneDigitOne == numTwoDigitTwo ||
                numOneDigitTwo == numTwoDigitOne || numOneDigitTwo == numTwoDigitTwo) {
            return true;
        }

        return false;
    }

    // Exercise 19 - Last Digit Checker
    public static boolean isValid (int num) {
        if (num >= 10 && num <= 1000) {
            return true;
        }
        return false;
    }

    public static boolean hasSameLastDigit (int numOne, int numTwo, int numThree) {
        if (!isValid(numOne) || !isValid(numTwo) || !isValid(numThree)) {
            return false;
        }

        int lastDigitOne = numOne % 10;
        int lastDigitTwo = numTwo % 10;
        int lastDigitThree = numThree % 10;

        if (lastDigitOne == lastDigitTwo || lastDigitOne == lastDigitThree || lastDigitTwo == lastDigitThree) {
            return true;
        }
        return false;
    }

    // Exercise 20 - Greatest Common Divisor
    public static int getGreatestCommonDivisor (int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }

        int endStep = (first <= second ? first : second);
        int step = 1;
        int commonDenom = 1;
        int firstRem = -1;
        int secondRem = -1;

        while (step <= endStep) {
            firstRem = first % step;
            secondRem = second % step;
            if (firstRem == 0 && secondRem == 0) {
                commonDenom = step;
            }
            step ++;
        }
        return commonDenom;
    }

    // Exercise 21 - Print All Factors
    public static void printFactors (int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        int step = 1;
        int rem = -1;
        while (step <= number) {
            rem = number % step;
            if (rem == 0) {
                System.out.println(step);
            }
            step++;
        }
    }

    // Exercise 22 - Perfect Number (sum of its proper positive divisors is the number itself)
    public static boolean isPerfectNumber(int number) {

        if (number < 1) {
            return false;
        }
        
        int step = 1;
        int endStep = Math.round(number/2);
        int denomSum = 0;
        int rem = -9999;
        
        while (step <= endStep) {
            rem = number % step;

            if (rem == 0) {
                System.out.println(step);
                denomSum += step;
            }
            step++;
        }
        System.out.println(denomSum);
        if (denomSum == number) {
            return true;
        }

        return false;
    }
}
