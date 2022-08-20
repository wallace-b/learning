package com.bradley;

public class Car extends Vehicle {

    private int axles;
    private int wheels;

    public Car(String name, int engines, int doors, int axles, int wheels, String steering) {
        super(name, engines, doors, steering);
        this.axles = axles;
        this.wheels = wheels;
    }

    public void brake(){
        System.out.println(name + " is braking to stop! Sccrrrhhhhh~~");
    }

}
