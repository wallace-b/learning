import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in); // create scanner object
        System.out.println("Enter the radius of a circle (a number): ");

        double myNumber = myObj.nextDouble(); // read user input
        double myDiameter = myNumber*2;
        double myCircumference = myDiameter * Math.PI;
        double myArea = Math.PI*Math.pow(myNumber,2.0);
        
        System.out.println("Diameter: " + myDiameter);
        System.out.println("Circumference: " + myCircumference);
        System.out.println("Area: " + myArea);

    }
}
