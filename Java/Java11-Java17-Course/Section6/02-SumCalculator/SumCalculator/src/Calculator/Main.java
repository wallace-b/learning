package Calculator;

public class Main {
    public static void main(String args[]){
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(55);
        calculator.setSecondNumber(12);
        double valueOne = calculator.getMultiplicationResult();
        System.out.println(valueOne);



    }
}
