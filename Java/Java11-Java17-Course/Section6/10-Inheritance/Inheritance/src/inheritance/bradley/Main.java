package inheritance.bradley;

public class Main {
    public static void main(String args[]){

        Dog dogZero = new Dog("Labrador", 5, 5, 2, 4,2,
                1, 20, "short silky");
        dogZero.eat();
        dogZero.walk();
        dogZero.run();
        dogZero.move(6);

        Fish fishZero = new Fish("Salmon", 2, 2, 10, 2,7);
        fishZero.move(6);

    }
}
