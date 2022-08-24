package com.bradley;

public class Car extends Vehicle {

    private int axles;
    private int wheels;

    public Car(String name, int engines, int doors, int axles, int wheels, String steering, boolean isManual) {
        super(name, engines, doors, steering, isManual);
        this.axles = axles;
        this.wheels = wheels;
    }

    @Override
    public void stop(){
        System.out.println(super.getName() + " is braking to stop! Sccrrrhhhhh~~");
        setSpeed(0);
    }

}
