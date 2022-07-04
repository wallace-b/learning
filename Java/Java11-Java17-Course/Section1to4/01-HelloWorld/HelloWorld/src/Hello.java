public class Hello {

    public static void main(String[] args) {
        double myDoubleFirst = 3 + 0.1 + 0.04;
        int myIntegerFirst = (10 % 4) + 3;
        double myDoubleTotal = myDoubleFirst + myIntegerFirst;
        double myDoubleLast = 100 - myDoubleTotal;
        // specify var type, ex: boolean, byte, short, long,
        //  char ('X'), String ("XXXXX") --> expression, declaration statement
        System.out.println("Hello World");
        System.out.println("Pi is approximately " + myDoubleFirst);
        System.out.println(myIntegerFirst);
        System.out.println(myDoubleTotal);
        System.out.println(myDoubleLast);

        // greyed out means variable is declared, but never used
    }
}
