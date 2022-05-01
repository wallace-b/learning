public class Main {
    public static void main(String[] args){
        int myResult = 1 + 2; // 3

        myResult++; // 4, same as myResult = myResult + 1, or myResult += 1
        System.out.println(myResult);

        myResult += 5; // 9, same as myResult = myResult + 5
        System.out.println(myResult);

        myResult--; // 8, same as myResult = myResult - 1
        System.out.println(myResult);
        myResult -= 5; // 3, same as myResult = myResult - 5
        System.out.println(myResult);

        int myStorage = myResult; // 3
        myResult *= 20; // 60, same as myResult = myResult * 20
        System.out.println("myStorage = " + myStorage);
        System.out.println(myResult);

        myResult /= 5; // 60/5 -> 12, same as myResult = myResult / 5
        System.out.println(myResult);

        myResult = myResult % 5; // 2, 12 % modulus 5 --> remainder 2
        System.out.println(myResult);

        // ---- while loops, if-then statements ---- //

        int myCounter = 0;
        int mySum = 1;
        while (myCounter <= 10) {

            mySum += myCounter;
            System.out.println("myCounter = " + myCounter);
            System.out.println("mySum = " + mySum);
            System.out.println("----------------");

            if (myCounter > 8 && mySum >= 30) {
                System.out.println("Wow! myCounter is > 8 AND mySum >= 30");
                System.out.println("------------------------------------");
            }

            if (myCounter == 5 || mySum > 50) {
                System.out.println("Wow! myCounter is 5 OR mySum > 50");
                System.out.println("------------------------------------");

            }

            myCounter++;

        }
        // use { } for code-block so that if cond. logic can run more than 1 line after a semicolon
        // relational operators: ==, !=, >, <, >=, <=
        // AND logical operator &&, one & (ampersand) is a bit AND, not a logical AND
        // OR logical operator ||,  one | (pipe) is a bitwise OR, not a logical OR

        boolean isHuman = true;
        boolean isAlien = false;
        if (isHuman) {
            System.out.println("Is a human.");
        }
        if (!isAlien) {
            System.out.println("Is DEFINITELY not an alien.");
        }

        // (isHuman == true) is the same as (isHuman)
        // (isAlien == false) is the same as (!isAlien)

        // ----- Ternary Operator ----- //
        // [XXXX condition] ? [if condition is true] : [if condition is false]

        int wasHumanInt = isHuman ? 1 : 0; // isHuman
        boolean wasHumanBoolean = !isAlien ? true : false; // can be simplified to simply = !isAlien
        System.out.println(wasHumanInt);
        System.out.println(wasHumanBoolean);
        
        // another example using a String
        int myScore = 50000;
        String myString = (myScore >= 25000) ? "That's a very high score!" : "That's a low score!";
        System.out.println(myString);


    }
}
