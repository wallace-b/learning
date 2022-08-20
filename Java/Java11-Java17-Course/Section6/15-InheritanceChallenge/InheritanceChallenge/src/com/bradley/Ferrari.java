package com.bradley;

public class Ferrari extends Car{
    public Ferrari(String name, int engines, int doors, int axles, int wheels, String steering) {
        super(name, engines, doors, axles, wheels, steering);
    }

    @Override
    public void speed(int speed) {
        System.out.println("The Ferrari " + name + " is a really fast car. It is travelling at " + (speed*2) + " km/h.");
    }
}
