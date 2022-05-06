public class Main {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 7;
        int bonus = 1000;
        int result = calculateScore(gameOver, score, levelCompleted, bonus);

        gameOver = false;
        result = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println(result);

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if(gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 5000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }

        return -1;

    }
}
