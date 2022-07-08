public class Strings {

    public static void main(String[] args) {
        // 8 primitive data types
        // byte
        // short
        // int * usually
        // long ~ sometimes
        // float
        // double * usually
        // char ~ sometimes
        // boolean * usually
        // you can make your own data types --> classes

        // string is technically a class, but enjoys some favoritism in Java to make it easier to use than a Class
        // strings are immutable
        String myString = "hello world";
        System.out.println("my string is equal to " + myString);
        myString = myString + ", hello moon! Yo";
        myString = myString.concat(", and this is more."); // same as above
        System.out.println(myString);
        // string buffers are more efficient!
        
    }
}
