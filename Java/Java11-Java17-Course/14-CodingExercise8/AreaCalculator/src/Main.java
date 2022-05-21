public class Main {

    private static double ERROR_MESSAGE = -1.0;

    public static double area(double radius) {
        if (radius < 0) {
            return ERROR_MESSAGE;
        }

        return (radius*radius)*Math.PI;
    }

    public static double area(double sideX, double sideY) {
        if (sideX < 0 || sideY < 0) {
            return ERROR_MESSAGE;
        }

        return sideX * sideY;
    }

}