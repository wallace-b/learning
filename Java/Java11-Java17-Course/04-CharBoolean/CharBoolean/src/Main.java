public class Main {
    public static void main(String[] args) {
        char myChar = 'D';
        char myUnicodeChar = '\u0044';
        // single character with single apostrophes ('X') and not double (ex: "X"
        // takes up 16 bits or two bytes of Unicode to represents 65535 diff types of chars
        // see ~ unicode-table.com/en
        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);

        boolean myBooleanTrue = true;
        boolean myBooleanFalse = false;

        System.out.println(myBooleanTrue);
        System.out.println(myBooleanFalse);
    }
}
