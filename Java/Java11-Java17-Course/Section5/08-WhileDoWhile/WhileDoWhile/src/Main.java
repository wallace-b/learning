public class Main {

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
        do {
            count ++;
            System.out.println(count);
        } while (count != 5); // do while loops always execute at least once...
        // ...because code reads left-right, line-by-line. Therefore, ...
        // ... the while condition is not checked before the do while loop has executed...
        // ... at least one time.
    }

}
