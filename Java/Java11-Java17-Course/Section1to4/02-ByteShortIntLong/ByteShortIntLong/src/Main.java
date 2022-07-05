public class Main {
    public static void main(String[] args) {

        // byte, short, int, long are integers are varying size dependent on memory allocation

        int myValue = 10000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println(myValue);
        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);
        ;
        System.out.println("BUSTED underflow Minimum Value = " + (myMinIntValue - 1)); // goes to Max value
        System.out.println("BUSTED overflow Maximum Value = " + (myMaxIntValue + 1)); // goes to Min value

        int mySecondValue = 2_147_483_647; // _ representation for readability, 2147483648 is too large **

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = " + myMinByteValue);
        System.out.println("Byte Maximum Value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myMinShortValue);
        System.out.println("Short Maximum Value = " + myMaxShortValue);

        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value = " + myMinLongValue);
        System.out.println("Long Maximum Value = " + myMaxLongValue);

        long bigLongLiteralValue = 2_147_483_647_234L; // add L to convert int to long in literal declaration

        System.out.println(Math.pow(2, 7));
        System.out.println(Math.pow(2, 15));
        System.out.println(Math.pow(2, 31));
        System.out.println(Math.pow(2, 63));
        // Byte occupies 8 bits
        // Short occupies 16 bits
        // Int occupies 32 bits
        // Long occupies 64 bits

        // -------- casting -------- // treat or conv. a number from one type to another.
        int myTotal = myMinIntValue / 2; // no problem -2147483648 / 2

        byte myNewByteValue = (byte)(myMinByteValue /2);
        // provided type int, req: byte, but we know the number will fit within byte min-max.
        // we tell Java to cast it to a byte type.

        short myNewShortValue = (short)(myMinShortValue / 2);
        // similar to above

        long myNewLongValue = myMinLongValue/2;
        // no need to cast

        // ----- Exercise ----- //
        byte myExerciseByte = -100;
        short myExerciseShort = 320;
        int myExerciseInt = 2144000;
        long myExerciseLong = 50000 + 10*(myExerciseByte + myExerciseShort + myExerciseInt);
        System.out.println(myExerciseLong);

    }

}
