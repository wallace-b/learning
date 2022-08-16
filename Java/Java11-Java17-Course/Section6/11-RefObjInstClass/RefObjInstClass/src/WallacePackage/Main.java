package WallacePackage;

public class Main {
    public static void main(String args[]){
        House whiteHouse = new House("white"); // new object created - white
        House anotherHouse = whiteHouse;

        System.out.println(whiteHouse.getColor()); // white
        System.out.println(anotherHouse.getColor()); // white

        anotherHouse.setColor("black"); // anotherHouse has the same reference as whiteHouse -> one object

        System.out.println(whiteHouse.getColor()); // black
        System.out.println(anotherHouse.getColor()); // black

        House greenHouse = new House("green"); // new object created - green
        anotherHouse = greenHouse; // anotherHouse now has the same reference as greenHouse
        // there are now two objects in memory whiteHouse and greenHouse

        System.out.println(whiteHouse.getColor()); // black
        System.out.println(greenHouse.getColor()); // green
        System.out.println(anotherHouse.getColor()); // green


    }


}
