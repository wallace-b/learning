public class Main {

    public static void main(String args[]){
        System.out.println("Yo!");

        double output = calcFeetAndInchesToCentimeters(-5);
        printResult(output);

        output = calcFeetAndInchesToCentimeters(-1, 7);
        printResult(output);

        output = calcFeetAndInchesToCentimeters(799);
        printResult(output);

        output = calcFeetAndInchesToCentimeters(66, 7);
        printResult(output);
    }

    public static double calcFeetAndInchesToCentimeters(double feetInput, double inchesInput) {
        if ((feetInput >= 0) && (inchesInput >= 0) && (inchesInput <= 12)) {
            double centimetersResult = feetInput * 30.48 + inchesInput * 2.54;
            return centimetersResult;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inchesInput) {
        if (inchesInput >= 0) {
            double feetResult = Math.floor(inchesInput / 12);
            double inchesRemainder = inchesInput % 12;
            double newResult = calcFeetAndInchesToCentimeters(feetResult, inchesRemainder);
            return newResult;
        }
        return -1;
    }

    public static void printResult(double input) {
        if (input < 0) {
            System.out.println("Invalid Input.");
        } else {
            System.out.println(input + " cm");
        }
    }

}
