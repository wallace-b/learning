package com.bradley;

public class Vehicle {
    private String name;
    private int engines;

    private int speed;

    private int direction; // 0-359 degrees
    private int doors;
    private String steering;
    private boolean isManual;
    private int gear;

    public Vehicle(String name) {
        this(name, 1, 1, "steering wheel with hands", false);
        // 1 engine, 1 door, hand steering wheel and automatic transmission by default
    }

    public Vehicle(String name, int engines, int doors, String steering, boolean isManual) {
        this(name, engines, 0, 0, doors, steering, isManual); // default 0 speed (stopped) and 0 direction (north)
    }

    public Vehicle(String name, int engines, int speed, int direction, int doors, String steering, boolean isManual) {
        this.name = name;
        this.engines = engines;
        this.speed = speed;
        this.direction = direction;
        this.doors = doors;
        this.steering = steering;
        this.isManual = isManual;
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

    public void setGear(int gear){
        this.gear = gear;
        System.out.println(name + " is currently in " + this.gear + ".");
    }

    public int getGear(){
        return gear;
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
