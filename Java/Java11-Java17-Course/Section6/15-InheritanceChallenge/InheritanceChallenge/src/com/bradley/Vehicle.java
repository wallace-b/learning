package com.bradley;

public class Vehicle {
    private String name;
    private int engines;
    private int speed;
    private int direction; // 0-359 degrees
    private int doors;
    private String steering;

    public Vehicle(String name) {
        this(name, 1, 1, "steering wheel with hands");
    }

    public Vehicle(String name, int engines, int doors, String steering) {
        this.name = name;
        this.engines = engines;
        this.doors = doors;
        this.steering = steering;
    }

     public String getName(){
        return name;
     }

    public void setSpeed(int speed){
        this.speed = speed;
        System.out.println(name + " is travelling at " + this.speed + " km/h.");
    }

    public int getSpeed(){
        return speed;
    }

    private int dir;
    public void setDirection(int direction){

        if(direction<0) {
            dir = (360 + direction % 360) % 360;
        } else {
            dir = direction % 360;
        }
        this.direction = dir;
        System.out.println(name + " is travelling facing " + this.direction + " degrees.");
    }

    public int getDirection(){
        return direction;
    }

    public void adjustDirection(int direction){
        if(direction<0) {
            dir = (360 + direction % 360) % 360;
        } else {
            dir = direction % 360;
        }
        this.direction = (this.direction + dir) % 360;
        System.out.println(name + " is travelling facing " + this.direction + " degrees.");
    }

    public void increaseSpeed(int speed){
        this.speed += speed;
        System.out.println(name + " is travelling at " + this.speed + " km/h.");
    }

    public void startEngine(){
        System.out.println("Starting " + name + "'s " + engines + " engine(s)!!");
    }

    public void stop(){
        System.out.println(name + " is stopping!");
        setSpeed(0);
    }

}
