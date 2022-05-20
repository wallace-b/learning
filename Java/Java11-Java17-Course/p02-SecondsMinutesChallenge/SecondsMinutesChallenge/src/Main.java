public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";
    // final => means it is a constant i.e. a final value
    // static => means we are going to use this var in static methods

    public static void main(String args[]) {
        // INVALID_VALUE_MESSAGE = "wow"; ! a constant cannot be changed

        String result = getDurationString(75, 6);
        System.out.println(result);

        String resultTwo = getDurationString(1215);
        System.out.println(resultTwo);

        String resultThree = getDurationString(600, 15);
        System.out.println(resultThree);

        String resultFour = getDurationString(-5, 15);
        System.out.println(resultFour);

        String resultFive = getDurationString(6, 100);
        System.out.println(resultFive);

        String resultSix = getDurationString(5);
        System.out.println(resultSix);

    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }
        int hours = Math.round(minutes / 60);
        int remainderMinutes = minutes % 60;
        int actualMinutes = (hours > 0) ? remainderMinutes : minutes;

        // leading zeros
        String hoursStrings = (hours< 10) ? ("0" + hours) : ("" + hours);
        String minutesStrings = (actualMinutes< 10) ? ("0" + actualMinutes) : ("" + actualMinutes);
        String secondsStrings = (seconds< 10) ? ("0" + seconds) : ("" + seconds);
        return (hoursStrings + "h " + minutesStrings + "m " + secondsStrings + "s");
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }
        int minutes = Math.round(seconds / 60);
        int remainderSeconds = seconds % 60;
        return getDurationString(minutes, remainderSeconds);
    }

}
