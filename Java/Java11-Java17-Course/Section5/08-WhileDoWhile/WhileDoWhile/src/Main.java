public class Main {

    public static boolean isEvenNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void printEvenSum(int start, int end) {
        int sum = 0;
        int step = start;
        while (step <= end) {
            if (isEvenNumber(step)) {
                System.out.println("Even number detected: " + step);
                sum += step;
            }
            step++;
        }
        System.out.println("Sum of even numbers: " + sum);
        System.out.println("*If sum = 0, check the range.");
    }

    public static void main(String args[]) {
        // example of While loop
        int count = 0;
        while (count != 5) {
            count ++;
            System.out.println(count);
        } // counts from 1-5 in while loop

        // example of Do While loop
        count = 0;
        do {
            count ++;
            System.out.println(count);
        } while (count != 5); // also counts from 1-5 in while loop

        count = 5;
        while (count != 5) {
            count ++;
            System.out.println(count);
        } // will not execute while loop

        // count = 5;
        count = 4;
        do {
            count ++;
            System.out.println(count);
        } while (count != 5); // do while loops always execute at least once...
        // ...because code reads left-right, line-by-line. Therefore, ...
        // ... the while condition is not checked before the do while loop has executed...
        // ... at least one time.

        // isEvenNumber method usage for a range
        System.out.println("==== Even Number Method calls ====");
        printEvenSum(6, 12);

    }

}
