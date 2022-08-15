package inheritance.bradley;

public class Dog extends Animal{

    private int eyes;
    private int legs;
    private int ears;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int ears,
               int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.ears = ears;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;

    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called.");
        chew();
        super.eat();

    }

    private void chew() {
        System.out.println("Dog.chew() called.");
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.walk() called");
        super.move(10);
    }

    private void moveLegs() {
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs();
        super.move(speed);
    }




}
