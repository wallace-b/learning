package bradleywallace;

public class Main {

    public static void main(String[] args){
        Car ferrari = new Car(); // create the class *important
        Car porsche = new Car(); // create the class *important
        ferrari.setModel("EnZo");
        System.out.println(ferrari.getModel());
        porsche.setModel("Carrera 119");
        System.out.println(porsche.getModel());

   }

}
