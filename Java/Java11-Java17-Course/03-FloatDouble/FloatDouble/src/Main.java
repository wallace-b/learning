public class Main {

    public static void main(String[] args) {
        // Float -> single precision 32 bits, 1.4E-45 to ~3.403E+38
        // Double -> double precision 64 bits, 4.9E-324 to ~1.798+308

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimum value = " + myMinFloatValue);
        System.out.println("Float maximum value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimum value = " + myMinDoubleValue);
        System.out.println("Double maximum value = " + myMaxDoubleValue);

        int myIntValue = 5; // Int is the default integer/whole number type
        float myFloatValue = 5.25f; // or = (float)5.25.... = 5.25 comes with error as Double is the default floating number type
        double myDoubleValue = 5.25d;

        // double is the preferred data type to use for floating point numbers.

        int myIntVal1 = 5/3;
        float myFloatVal1 = 5f/3f;
        double myDoubleVal1 = 5d/3f;
        double myDoubleVal2 = 5.00/3.00;
        System.out.println("Int1= " + myIntVal1);
        System.out.println("Float1= " + myFloatVal1);
        System.out.println("Double1= " + myDoubleVal1);
        System.out.println("Double2= " + myDoubleVal2);

        // modern computers are equipped to process doubles (same as Java), and thus doubles are actually processed ...
        // ... faster than floats

        // ----- lbs to kgs converter -----
        double myMassPounds = 160d;
        double myMassKilograms = myMassPounds * 0.45359237d;
        System.out.println("my mass in kilograms = " + myMassKilograms);

        // for precise numbers use BigDecimal
    }
}
