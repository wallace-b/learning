public class Main{

    public static void main(String[] args) {
        double myVarA = 20.00d;
        double myVarB = 80.00d;
        double myStepThree = (myVarA + myVarB) * 100.00d;
        double myStepFour = myStepThree % 40.00d;
        boolean myStepFive = myStepFour == 0;
        System.out.println(myStepFour);
        System.out.println(myStepFive);
        if (!myStepFive) {
            System.out.println("Got some remainder.");
        }
    }

}
