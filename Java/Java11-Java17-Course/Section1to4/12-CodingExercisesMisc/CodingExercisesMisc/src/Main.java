import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {


    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(1500);

        System.out.println(shouldWakeUp(true, 7));
        System.out.println(shouldWakeUp(false, 7));
        System.out.println(shouldWakeUp(true, -1));
        System.out.println(shouldWakeUp(true, 9));
        System.out.println(shouldWakeUp(true, 23));
        System.out.println(shouldWakeUp(true, 5));

        System.out.println("------Exercise #4------");
        System.out.println(isLeapYear(10000));
        System.out.println(isLeapYear(1800));

        System.out.println("------Exercise #5------");
        System.out.println(areEqualByThreeDecimalPlaces(-3.175, -3.1756));

        System.out.println("------Exercise #6------");
        int alpha = 3;
        int beta = -1;
        int sumAlphaBeta = 2;
        System.out.println(alpha + " + " + beta + " == " + sumAlphaBeta + " ?");
        System.out.println(hasEqualSum(alpha, beta, sumAlphaBeta));

        alpha = 2;
        beta = 1;
        sumAlphaBeta = 4;
        System.out.println(alpha + " + " + beta + " == " + sumAlphaBeta + " ?");
        System.out.println(hasEqualSum(alpha, beta, sumAlphaBeta));

        System.out.println("------Exercise #7------");
        int personOneAge = 16;
        int personTwoAge = 11;
        int personThreeAge = 22;
        System.out.println("Ages: " + personOneAge + ", " + personTwoAge + ", " + personThreeAge + " has teen?");
        System.out.println(hasTeen(personOneAge, personTwoAge, personThreeAge));

        personOneAge = 25;
        personTwoAge = 9;
        personThreeAge = 31;
        System.out.println("Ages: " + personOneAge + ", " + personTwoAge + ", " + personThreeAge + " has teen?");
        System.out.println(hasTeen(personOneAge, personTwoAge, personThreeAge));

    }

    // Coding Exercise #2: KB to MB converter, integer MBs with residual KBs
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = Math.round(kiloBytes / 1024);
            int remKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remKiloBytes + " KB");
        }
    }

    // Coding Exercise #3: Barking Dog alarm
    public static boolean shouldWakeUp(boolean dogBarking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false; // returns false if outside of valid 0-23hrs (24hr clock) i.e. invalid input range
        } else return dogBarking && (hourOfDay < 8 || hourOfDay > 22); // returns true in certain conditions
// return false in all other situations.
    }

    // Coding Exercise #4: Leap Year Calculator
    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) { // range-check (1,9999)

            if ((year % 4) == 0) {    // Step 1
                if ((year % 100) == 0) {   // Step 2
                    if ((year % 400) == 0) {  // Step 3
                        return true; // Step 4
                    }
                    return false; // Step 5
                }
                return true; // Step 4
            }
        }
        return false; // Step 5
    }

    // Coding Exercise #5: Decimal Comparator, to three decimal places (no rounding)
    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {
        DecimalFormat df = new DecimalFormat("0.###");
        df.setRoundingMode(RoundingMode.DOWN);
        double newFirst = Double.valueOf(df.format(first));
        double newSecond = Double.valueOf(df.format(second));
        if (newFirst == newSecond) { return true; } else { return false; }

    }

    // Coding Exercise #6: Sum Checker (intOne + intTwo == intSum?)
    public static boolean hasEqualSum(int first, int second, int sum) {
        boolean result = (first + second) == sum;
        return result;
    }

    // Coding Exercise #7: Is a number in the teens (13-19) in a set of 3 ints, calls another method
    public static boolean hasTeen(int first, int second, int third) {
        boolean result = (isTeen(first) || isTeen(second) || isTeen(third));
        return result;
    }
    public static boolean isTeen(int value) {
        boolean result = (value >= 13 && value <= 19);
        return result;
    }

}
