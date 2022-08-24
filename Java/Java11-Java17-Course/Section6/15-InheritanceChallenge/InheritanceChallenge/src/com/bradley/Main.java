package com.bradley;

// ** all classes extend the Object class **

public class Main {

    public static void main(String args[]){
        Vehicle boat = new Vehicle("Titanic", 4, 200, "rudder, wheel with hands", true);
        boat.startEngine();
        boat.setDirection(-735);
        boat.setSpeed(2);
        boat.increaseSpeed(15);
        boat.adjustDirection(-375);

        System.out.println("");

        Car hyundai = new Car("Hyundai Sonata", 1, 5, 2, 4,"wheel with hands", false);
        hyundai.startEngine();
        hyundai.setSpeed(50);
        hyundai.increaseSpeed(25);
        hyundai.stop();

        System.out.println("");

        Ferrari enzo = new Ferrari("Enzo", 1, 2, 2, 4,
                "wheel with hands", true);
        enzo.startEngine();
        enzo.setSpeed(20);
        enzo.increaseSpeed(25);
        enzo.stop();

    }
}
