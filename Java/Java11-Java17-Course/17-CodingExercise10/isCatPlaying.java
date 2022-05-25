public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature){
        if (summer == false && temperature >= 25 && temperature <= 35) {
            return true; // winter play between 25-35, inclusive
        }
        if (summer == true && temperature >= 25 && temperature <= 45) {
            return true; // winter play between 25-45, inclusive
        }
        return false;
    }
}
