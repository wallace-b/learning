package CarpetCalculator;

public class Main {
    public static void main(String args[]){
        Floor floorOne = new Floor(5,6);
        Carpet carpetOne = new Carpet(10);
        Calculator calculatorOne = new Calculator(floorOne, carpetOne);
        double result = calculatorOne.getTotalCost();
        System.out.println("$" + result);
    }
}
