package com.bradley;

public class Vehicle {
    public String name;
    public int engines;
    public int doors;
    public String steering;


    public Vehicle(String name) {
        this(name, 1, 1, "steering wheel with hands");
    }

    public Vehicle(String name, int engines, int doors, String steering) {
        this.name = name;
        this.engines = engines;
        this.doors = doors;
        this.steering = steering;
    }

    public void speed(int speed){
        System.out.println(name + " is travelling at " + speed + " km/h.");
    }

    public void startEngine(){
        System.out.println("Starting " + engines + " engine(s)!!");
    }

}
