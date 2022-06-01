public class NumberInWord {
        // write your code here
    public static void printNumberInWord(int number) {
        String[] arrayDays = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        if (number >= 0 && number <= 9) {
        System.out.println(arrayDays[number]);
        } else {
        System.out.println("OTHER");
        }
    }
}
