public class Main {

    public static long toMilesPerHour(double kilometersPerHour) {
        long result = -1;
        if (kilometersPerHour >= 0) {
            result = Math.round(kilometersPerHour / 1.609);
        }
        return result;
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour >= 0) {
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        } else {
            System.out.println("Invalid Value");
        }
    }
}
