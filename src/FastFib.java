import java.math.BigInteger;

/**
 * Created by michaelgrimes on 9/11/14.
 */
public class FastFib {

    public static void main(String[] args) {

        long start = 100;

        System.out.println(fastFib(4780).toString().length());

//        while (fastFib(start).toString().length() != 1000) {
//            start += 1;
//            if (start % 50 == 0) {
//                System.out.println("start is " + start);
//            }
//        }

        System.out.println("first fib with 1000 digits is: " + start);

    }

    static BigInteger fastFib(long n) {

        BigInteger n1 = BigInteger.valueOf(0);
        BigInteger n2 = BigInteger.valueOf(1);

        BigInteger temp;

        for (int i = 0; i <= n - 2; i++) {
            temp = n2;
            n2 = n1.add(n2);
            n1 = temp;
        }

        return n1.add(n2);
    }


}
