package com.bradley;

public class Ferrari extends Car{

    private boolean spoiler;
    public Ferrari(String name, int engines, int doors, int axles, int wheels, String steering, boolean spoiler) {
        super(name, engines, doors, axles, wheels, steering);
        this.spoiler = spoiler;
    }

    @Override
    public void increaseSpeed(int speed) {
        super.increaseSpeed(2*speed);
    }
}
