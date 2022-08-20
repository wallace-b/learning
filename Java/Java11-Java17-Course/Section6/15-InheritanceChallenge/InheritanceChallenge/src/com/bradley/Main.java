package com.bradley;

// ** all classes extend the Object class **

public class Main {

    public static void main(String args[]){
        Vehicle boat = new Vehicle("Titanic", 4, 200, "rudder, wheel with hands");
        boat.speed(15);
        boat.startEngine();

        Car hyundai = new Car("Hyundai Sonato", 1, 5, 2, 4,"wheel with hands");
        hyundai.speed(50);
        hyundai.startEngine();
        hyundai.brake();

        Ferrari enzo = new Ferrari("Enzo", 1, 2, 2, 4, "wheel with hands");
        enzo.speed(50);

    }
}
