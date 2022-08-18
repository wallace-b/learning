package PackageBradley;

// ======= Overloading ========
// Overloading -> X polymorphism, but Java Developers often refer to overloading as Compile Time Polymorphism. ...
// ... i.e. the compiler decides which method is going to be called based on the method name, return type and argument list.
// we can overload static and instance methods

// Methods can be overloading if both apply: same method name, different parameters. They can have different return types, ...
// ... and different access modifiers.

// ======= Overriding ========
// Overriding means defining a method in a child class that already exists in the parent class with the same name/signature.
// Method overriding is also known as Runtime Polymorphism and Dynamic Method Dispatch, because the method that is going to be called...
// ... is decide at runtime by the Java Virtual Machine.
// use '@Override' immediately above the method definition. It's an annotation that the compiler reads and will show us errors, ...
// ... if we don't follow overriding rules correctly.
// We can't override static methods, only instance methods.
// Rules: same name and arguments, return type can be a subclass of the return type in the parent class, can't have a lower access modifier
// Only inherited methods can be overridden. Constructors and private methods, final methods,  cannot be overridden.

public class Main {

    public static void main(String args[]){
        DogOverride dog0 = new DogFarm().createDog();
        dog0.bark();

        BigDog dog1 = new BigDogFarm().createDog();
        dog1.bark();
    }

}
