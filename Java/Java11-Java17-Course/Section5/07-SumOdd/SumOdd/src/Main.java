public class Main {
    public static void main(String args[]) {
        System.out.println(isOdd(-1));
        System.out.println(isOdd(1));
        System.out.println(isOdd(3));
        System.out.println(isOdd(4));
        System.out.println(sumOdd(1,10));
    }

    public static boolean isOdd(int number) {
        if (number <= 0) {
            return false;
        } if ((number % 2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        if (start > end || start <= 0 || end <= 0) {
            return -1;
        }
        for (int n = start; n <= end; n++) {
            if (isOdd(n)) { sum += n; }
        }
        return sum;
    }
}