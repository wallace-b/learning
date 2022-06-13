// Exercise 16 - First and Last Digit Sum

public class FirstLastDigitSum {
    
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
            number = Math.round(number/10);
        count++;
        }
    
        return firstDigit + lastDigit;
        
    }
    
}
