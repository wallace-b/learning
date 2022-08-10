public class PlayingCat {

    public static void main(String args[]) {
        boolean summerYes = true;
        int temp = 44;
        System.out.println("Is it Summer? " + summerYes);
        System.out.println("The temperature is: " + temp);
        System.out.println("Is the cat playing? " + isCatPlaying(summerYes, temp));

        summerYes = true;
        temp = 46;
        System.out.println("Is it Summer? " + summerYes);
        System.out.println("The temperature is: " + temp);
        System.out.println("Is the cat playing? " + isCatPlaying(summerYes, temp));

        summerYes = false;
        temp = 36;
        System.out.println("Is it Summer? " + summerYes);
        System.out.println("The temperature is: " + temp);
        System.out.println("Is the cat playing? " + isCatPlaying(summerYes, temp));
    }


    public static boolean isCatPlaying(boolean summer, int temperature){
        if (!summer && temperature >= 25 && temperature <= 35) {
            return true; // winter play between 25-35, inclusive
        }
        if (summer && temperature >= 25 && temperature <= 45) {
            return true; // summer play between 25-45, inclusive
        }
        return false;
    }
}
