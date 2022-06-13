public class Main {

    public static void main(String args[]){
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1201));
        System.out.println(isPalindrome(1221));

    }

    public static boolean isPalindrome(int number) {

        // this converts any negative numbers to positive numbers, since negativity is redundant for this test
        // the reverse of a negative number will always be negative, so let's just avoid trying to program...
        // ... the while loop around that scenario.
        if (number < 0) {
            number = number * -1;
        }

        int original = number;
        int reverse = 0;

        // this while loop shaves away 1 digit at a time at the end using /10 and Math.round
        // prior to this, the single digit is added to the reverse number
        // and prior to this, this reverse number is *10 to make way for the next single digit to be added
        // strange logic, but it works!
        // the while loop executes only if there is at least a single digit value > 0 || value >= 1 to work with.
        while (number >= 1) {

            reverse *= 10;
            reverse += number % 10;
            number = Math.round(number / 10);
            //System.out.println(reverse);

        }
        return (original==reverse);
    }

}