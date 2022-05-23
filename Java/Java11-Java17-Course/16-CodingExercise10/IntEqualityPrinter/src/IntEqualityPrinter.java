public class IntEqualityPrinter {

    public static void main(String args[]){
        printEqual(-1,1,1); // testing the Method printEqual
        printEqual(1,1,1);
        printEqual(1,2,3);
        printEqual(1,1,2);

    }

    public static void printEqual(int first, int second, int third) {
        if (first < 0 || second < 0 || third < 0) {
            System.out.println("Invalid Value");
            return;
        }

        if (first == second && first == third & second == third) {
            System.out.println("All numbers are equal");
            return;
        }

        if (first != second && first != third && second != third) {
            System.out.println("All numbers are different");
            return;
        }

        System.out.println("Neither all are equal or different");
        return;
    }
}