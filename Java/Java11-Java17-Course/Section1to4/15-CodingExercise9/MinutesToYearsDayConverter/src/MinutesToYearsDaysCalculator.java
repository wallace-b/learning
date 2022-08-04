public class MinutesToYearsDaysCalculator {

    public static void main(String args[]){
        printYearsAndDays(1752600);
    }
    private static String ERROR_MESSAGE = "Invalid Value";

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println(ERROR_MESSAGE);
            return;
        };
        int days = Math.round(minutes / (60*24));
        int years = 0;
        if (days >= 365) {
            years = Math.round(days / 365);
            days = days % 365;
        }

        String result = minutes + " min = " + years + " y and " + days + " d";
        System.out.println(result);
        return;


    }

}