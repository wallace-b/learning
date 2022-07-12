public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // a mile is equal to 1.609344 kilometres
        double kilometres = (100 * 1.609344d);
        int highScore = 50;

        if (highScore == 50) {
            System.out.println("This is another expression.");
            System.out.println("This is" +
                    " another " +
                    "expression.");
            // you can continue statements over multiple lines
            // you can run multiple lines in an if-then using a code-block
        }

        if (highScore >= 45)
            System.out.println("High Score >= 45");
            // you can run a single line after an if-then without a code-block

        highScore++;
        System.out.println(highScore);
        kilometres++;
        System.out.println(kilometres);
        // you can put statements on the same line, separated by ';'

        int score = 500;

        if (score >= 1000 && score < 5000) {
            System.out.println("A mid-range score: " + score);
        } else if (score < 1000) {
            System.out.println("A low score: " + score);
        } else {
            System.out.println("Must be a high score: " + score);
            int finalScore = score;
        }

        // System.out.println(finalScore);
        // you cannot access a variable made within an if-else-then statement
        // this is called 'scope'. A concept where the 'scope' is limited to within
        // the if-then statement.

        // exercise - accessing a variable, declaring a variable before the if-then statement
        int newScore = 10000;
        int levelCompleted = 8;
        int bonus = 200;
        boolean gameOver = true;

        int finalScore = 0;
        finalScore += 5;

        if (gameOver) {
            finalScore = newScore + (levelCompleted * bonus);
        }

        System.out.println("Your final score was " + finalScore); // no extra 5 is found in the final answer

    }
}
