/**
 * Created by michaelgrimes on 9/11/14.
 */
public class GiantSieve {

    public static void main(String[] args) {



        boolean[] giantSieve = new boolean[2000000];

        for (int i = 2; i < giantSieve.length; i++) {
            // System.out.println("i: " + i);
            for (int j = 2 * i; j < giantSieve.length; j += i) {
                giantSieve[j] = true;
            }
        }


        // Used for project euler problem #7
//        int count = 0;
//        for (int i = 2; i < giantSieve.length; i++) {
//            if (!giantSieve[i]) count++;
//            if (count == 10001) {
//                System.out.println(i);
//                break;
//            }
//        }

//        for (int i = 0; i < 100; i++) {
//            if (!giantSieve[i]) System.out.println(i);
//        }

        // Project Euler problem # 10
        // get sum of all primes < 2,000,000

        long sum = 0;
        for (int i = 2; i < giantSieve.length; i++) {
            if (!giantSieve[i]) sum += i;
        }

        System.out.println(sum);

    }

}
