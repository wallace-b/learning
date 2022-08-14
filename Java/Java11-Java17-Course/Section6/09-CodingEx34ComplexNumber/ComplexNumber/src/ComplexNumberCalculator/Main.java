package ComplexNumberCalculator;

public class Main {
    public static void main(String args[]){
        ComplexNumber newOne = new ComplexNumber(5.5, 6.4);
        System.out.println("The complex number is " + newOne.getReal() + " + " + newOne.getImaginary() + "i");
    }
}
