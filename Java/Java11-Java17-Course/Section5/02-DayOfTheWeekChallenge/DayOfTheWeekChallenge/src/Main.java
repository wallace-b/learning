public class Main {

    public static void main(String args[]) {
        printDayOfTheWeek(0);
        printDayOfTheWeekTwo(6);
    }

    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            default:
                System.out.println("Invalid day");
                break;
        }
    }

    public static void printDayOfTheWeekTwo(int day) {
        String[] dayArray =
                {"Sunday", "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday"};
        if (day >= 0 && day <= 6) {
            System.out.println(dayArray[day]);
        } else {
            System.out.println("Invalid day");
        }
    }


}
