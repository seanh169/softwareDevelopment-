public class SpeedConverter {
    public static void main(String[] args) {

//        System.out.println(shouldWakeUp(true, 1));
//        System.out.println(shouldWakeUp(false, 2));
//        System.out.println(shouldWakeUp(true, 8));
//        System.out.println(shouldWakeUp(true, -1));
//        printMegaBytesAndKiloBytes(2500);

//        System.out.println(Math.round(3.176));

        areEqualByThreeDecimalPlaces(-3.1756 ,-3.175);
        areEqualByThreeDecimalPlaces(-3.176 ,-3.175);
//        System.out.println(-3.1756 * 1000);
//        System.out.println(-3.175 * 1000);
//        System.out.println((int)(-3175.6000000000004));
    }


    public static boolean areEqualByThreeDecimalPlaces(double p1, double p2){
        double f =  p1 * 1000;
        double g =  p2 * 1000;
        return (int)f == (int)g;
    }

//    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
//        if(hourOfDay < 0 || hourOfDay > 23){
//            return false;
//        }
//        if(barking && hourOfDay < 8 || barking && hourOfDay > 22){
//            return true;
//        }
//        return false;
//    }

//    public static long toMilesPerHour (double kilometersPerHour) {
//        if(kilometersPerHour < 0) {
//            return (long) -1;
//        }
//
//        long milesPerHour = Math.round(kilometersPerHour / 1.609);
//        System.out.println(milesPerHour);
//        return milesPerHour;
//    }

//    public static void printMegaBytesAndKiloBytes(int kiloBytes){
//        if(kiloBytes < 0) {
//            System.out.println("Invalid Value");
//        }else{
//            int mb = kiloBytes / 1024;
//            int remainder = kiloBytes % 1024;
//            System.out.println(kiloBytes + " KB = " + mb + " MB and " + remainder + " KB" );
//        }
//
//
//    }

}
