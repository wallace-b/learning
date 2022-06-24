import java.util.Arrays;

public class Main {

    public static int getLargestPrime(int number) {
        if (number <= 1) { return -1; }

        int result = -1; //default value, -1 if no prime found found

       // prime number array creation (up to 100 int values memory)
        int[] primeArray = new int[100];
        primeArray[0] = 2;

        // prime number finder nested for loops
        for (int i=3 ; i <= number; i++) {
            primeArray[i-2] = i; // place i in the primeArray as a default
            for (int j=2; j <= i-1; j++) {
                if (i % j == 0) {
                    primeArray[i-2] = 0; // if it is divisible by any other number than 1 or itself (j=1 to j=i-1)
                    break; // then set the value to default val 0
                }
            }
        }

        // filter out all 0 values from the array
        primeArray = Arrays.stream(primeArray).filter(num -> num != 0).toArray();
        System.out.println(Arrays.toString(primeArray));

        return result;
    }
}
