public class Main {

    public static void main(String[] args) {
        System.out.println("hello world!");

        displayHighScorePosition("Jeff", calculateHighScorePosition(1500));
        displayHighScorePosition("Bella", calculateHighScorePosition(900));
        displayHighScorePosition("Mason", calculateHighScorePosition(400));
        displayHighScorePosition("Alice", calculateHighScorePosition(50));
        displayHighScorePosition("MissingNo", calculateHighScorePosition(-9999));

    }

    public static int calculateHighScorePosition(int playerScore){

        int result = -1; // -1 is an error

        if (playerScore >= 1000) {
            result = 1;
        } else if (playerScore >= 500 && playerScore < 1000) {
            result = 2;
        } else if (playerScore >= 100 && playerScore < 500) {
            result = 3;
        } else if (playerScore >= 0 && playerScore < 100) {
            result = 4;
        }

        return result;
    }

    public static void displayHighScorePosition(String playerName, int highScorePosition){
        System.out.println(playerName + " managed to get into position "
                + highScorePosition + " on the rankings.");
    }
}
