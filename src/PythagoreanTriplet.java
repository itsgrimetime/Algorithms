/**
 * Created by michaelgrimes on 9/11/14.
 */
public class PythagoreanTriplet {

    public static void main(String[] args) {

        long a = 0;
        long b = 0;
        long c = 0;

        for (int ci = 1; ci < 1000; ci++) {
            for (int bi = 1; bi < ci; bi++) {
                for (int ai = 1; ai < bi; ai++) {
                    // System.out.println("a: " + ai + " b: " + bi + " c: " + ci);
                    if ((((long) Math.pow(ai, 2)) + ((long) Math.pow(bi, 2)) == ((long) Math.pow(ci, 2))) &&
                            (ai + bi + ci == 1000)) {
                        System.out.println(ai * bi * ci);
                    }
                }
            }
        }

    }



}
