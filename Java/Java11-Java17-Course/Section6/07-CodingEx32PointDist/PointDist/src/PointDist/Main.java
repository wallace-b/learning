package PointDist;

public class Main {
    public static void main(String args[]){
        Point zero = new Point(1,5);
        Point one = new Point (6,6);
        System.out.println(one.distance());
        System.out.println(one.distance(1,5));
        System.out.println(one.distance(zero));
    }
}
