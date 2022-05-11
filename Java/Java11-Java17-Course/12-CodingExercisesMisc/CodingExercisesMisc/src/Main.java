public class Main {


    public static void main(String[] args){
        printMegaBytesAndKiloBytes(1500);

        System.out.println(shouldWakeUp(true, 7));
        System.out.println(shouldWakeUp(false, 7));
        System.out.println(shouldWakeUp(true, -1));
        System.out.println(shouldWakeUp(true, 9));
        System.out.println(shouldWakeUp(true, 23));
        System.out.println(shouldWakeUp(true, 5));


    }

    // Coding Exercise #2: KB to MB converter, integer MBs with residual KBs
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            int megaBytes = Math.round(kiloBytes/1024);
            int remKiloBytes = kiloBytes % 1024;
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remKiloBytes + " KB");
        }
    }

    // Coding Exercise #3: Barking Dog alarm
    public static boolean shouldWakeUp(boolean dogBarking, int hourOfDay){
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false; // returns false if outside of valid 0-23hrs (24hr clock) i.e. invalid input range
        } else if (dogBarking && (hourOfDay < 8 || hourOfDay > 22)) {
            return true; // returns true in certain conditions
        }
        return false; // return false in all other situations.
    }
}
