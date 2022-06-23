public class Main {

    public static void main(String[] args) {
        String numberAsStringOne = "2022";
        String numberAsStringTwo = "2022.125";
        System.out.println("Number 1 as String = " + numberAsStringOne);
        System.out.println("Number 2 as String = " + numberAsStringTwo);

        int numberOne = Integer.parseInt(numberAsStringOne);
        double numberTwo = Double.parseDouble(numberAsStringTwo);
        System.out.println("Number 1 = " + numberOne);
        System.out.println("Number 2 = " + numberTwo);

        numberAsStringOne += 1;
        numberOne += 1;
        System.out.println("Number 1 as String = " + numberAsStringOne);
        System.out.println("Number 1 = " + numberOne);

        numberAsStringTwo += 1;
        numberTwo += 1;
        System.out.println("Number 2 as String = " + numberAsStringTwo);
        System.out.println("Number 2 = " + numberTwo);

    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal <= 0) {
            return false;
        }

        // if the delivery can be made up of entirely small bags, that is acceptable
        if (smallCount >= goal) {
            return true;
        }

        // if the exact delivery can be made up of entirely complete big bags, that is acceptable
        if (bigCount * 5 == goal) {
            return true;
        }

        // if big bags are under the delivery amount, can small bags make up the difference?
        if (bigCount * 5 < goal && bigCount * 5 + smallCount >= goal) {
            return true;
        }

        // if big bags are over the delivery amount, can big bags - 1 plus small bags make the delivery amount?
        if (bigCount * 5 > goal && ((bigCount - 1) * 5) + smallCount >= goal) {
            return true;
        }

        // otherwise return false
        return false;

    }

}





