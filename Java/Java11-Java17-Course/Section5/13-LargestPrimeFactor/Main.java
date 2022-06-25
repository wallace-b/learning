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

        // cycle through the array of prime number array [A] with 2 nested loops ...
        // ... Ai x Aj and Ai x Aj x Ak to check if the calculation = the original number
        // basically we are checking 2 factor and 3 factor calculations only
        // ... there may be a way to write this code in a general fashion for 2 factor, 3 factor, 4 factor, 5 factor...
        // ... calculations, but my skill is not that advanced.

        int calc = -1; // create a dummy int to store calculated values
        int primeArrayLength = primeArray.length; // determine the length of the Array i.e. the end step size

        for (int i=0; i<=primeArrayLength-1; i++) {
            for (int j=0; j<=primeArrayLength-1; j++) {
                if (primeArray[i] * primeArray[j] == number) {
                    calc = primeArray[i] >= primeArray[j] ? primeArray[i] : primeArray[j];
                    // if Ai*Aj==number, then store the larger value
                    if (calc > result) {
                        result = calc; // only update result if calc is greater than current result
                    }
                }
                for (int k=0; k<=primeArrayLength-1; k++) {
                    if (primeArray[i] * primeArray[j] * primeArray[k] == number) {
                        // if Ai*Aj*Ak==number, then store the largest value
                        // there may be a smarter/more efficient way to write these if statements ...
                        // ... but this makes the most sense conceptually. There would be duplication of
                        // calculations if Ai, Aj, Ak are the same value
                        if (primeArray[i] >= primeArray[j] && primeArray[i] >= primeArray[k]) {
                            calc = primeArray[i];
                        }
                        if (primeArray[j] >= primeArray[i] && primeArray[j] >= primeArray[k]) {
                            calc = primeArray[j];
                        }
                        if (primeArray[k] >= primeArray[i] && primeArray[k] >= primeArray[j]) {
                            calc = primeArray[k];
                        }
                        if (calc > result) {
                            result = calc; // only update result if calc is greater than current result
                        }
                    }
                }
            }
        }
        return result;
    }
}
