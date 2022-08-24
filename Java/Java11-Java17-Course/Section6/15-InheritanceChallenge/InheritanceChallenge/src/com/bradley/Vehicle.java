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
        if (this.speed < 0) {
            this.speed = 0;
        }
        System.out.println(name + " is travelling at " + this.speed + " km/h.");
        if (isManual) {
            if (this.speed > 0 && this.speed <= 15) {
                setGear(1);
                // no resetting gear to Gear 1 if completely stopped.
            }
            if (this.speed > 15 && this.speed <= 25) {
                setGear(2);
            }
            if (this.speed > 25 && this.speed <= 35) {
                setGear(3);
            }
            if (this.speed > 35 && this.speed <= 50) {
                setGear(4);
            }
            if (this.speed > 50 && this.speed <= 65) {
                setGear(5);
            }
            if (this.speed > 65) {
                setGear(6);
            }
        }
    }

    public int getSpeed(){
        return speed;
    }

    public void setGear(int gear){
        this.gear = gear;
        System.out.println(name + " is currently in Gear " + this.gear + ".");
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

    public int prevGear;
    public void increaseSpeed(int speed){
        this.speed += speed;
        if (this.speed < 0) {
            this.speed = 0;
        }
        System.out.println(name + " is travelling at " + this.speed + " km/h.");
        if (isManual) {
            prevGear = getGear();
            if (this.speed >= 0 && this.speed <= 15 && prevGear != 1) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 1.");
                setGear(1);
            }
            if (this.speed > 15 && this.speed <= 25 && prevGear != 2) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 2.");
                setGear(2);
            }
            if (this.speed > 25 && this.speed <= 35 && prevGear != 3) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 3.");
                setGear(3);
            }
            if (this.speed > 35 && this.speed <= 50 && prevGear != 4) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 4.");
                setGear(4);
            }
            if (this.speed > 50 && this.speed <= 65 && prevGear != 5) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 5.");
                setGear(5);
            }
            if (this.speed > 65 && prevGear != 6) {
                System.out.println("Vehicle changed from Gear " + prevGear + " to Gear 6.");
                setGear(6);
            }
        }
    }

    public void startEngine(){
        System.out.println("Starting " + name + "'s " + engines + " engine(s)!!");
        if (isManual) {
            setGear(1);
        }
    }

    public void stop(){
        System.out.println(name + " is stopping!");
        setSpeed(0);
    }

}
