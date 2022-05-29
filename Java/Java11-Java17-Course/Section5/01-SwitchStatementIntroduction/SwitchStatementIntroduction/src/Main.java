public class Main {

    public static void main(String args[]){
        // Example of if, else if, else statement
        int value = 3;
        if (value == 1) {
            System.out.println("Value was a 1");
        } else if (value == 2) {
            System.out.println("Value was a 2");
        } else if (value == 3 || value == 4 || value == 5) {
            System.out.println("Value was a 3, 4 or 5");
            System.out.println("Value was actually " + value);
        } else {
            System.out.println("Value was not 1-5, inclusive");
        }

        // Example of using a switch statement to achieve the same outcome as the if,elif,else statement
        // the default functions as the else statement
        // the break statement is critical, otherwise the switch statement will continue to enter each case...
        // ...until it encounters a break statement (or the end of the switch statement) to exit the switch statement.
        
        // Switch statements can use the four primitive data types - byte, short, char, int

        int switchValue = 3;
        switch (switchValue) {
            case 1:
                System.out.println("Value was a 1");
                break;

            case 2:
                System.out.println("Value was a 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Value was a 3, 4 or 5");
                System.out.println("Value was actually " + switchValue);
                break;

            default:
                System.out.println("Value was not 1-5, inclusive");
                break;

        }

        System.out.println("Reached the end.");

    }
}
