package inheritance.bradley;

public class Fish extends Animal{
    private int gills;
    private int eyes;
    private int fins;

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest(){

    }

    private void moveMuscles(){
        System.out.println("Fish.moveMuscles() called");
    }

    private void moveBackFin(){
        System.out.println("Fish.moveBackFin() called");
    }

    @Override
    public void move(int speed) {
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }
}
