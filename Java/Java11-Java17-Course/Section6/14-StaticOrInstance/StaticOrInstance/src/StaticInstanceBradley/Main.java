package StaticInstanceBradley;

public class Main {

    public static void main(String args[]) {
        Calculator.printSum(5,7);
        printHello();

        // Cat.meow(); cannot be referenced in a static context ~error
        Cat jeff = new Cat();
        jeff.meow();
    }

    public static void printHello(){
        System.out.println("Hello.");
    }
}

// Should a method be static?
// IF it uses any fields (instance variables) or instance methods, it should probably be an instance method.
// IF NOT, it should probably be a static method.

// Also, 'this' cannot be called in a static method.