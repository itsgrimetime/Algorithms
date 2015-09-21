import java.math.BigInteger;

/**
 * Created by michaelgrimes on 9/11/14.
 */
public class SumSquareDiff {

    public static void main(String[] args) {


        long sumOfSquares = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += Math.pow(i, 2);
        }

        System.out.println(sumOfSquares);

        long sum = (100 * (100 + 1)) / 2;
        long squareOfSums = (long) Math.pow(sum, 2);

        System.out.println(squareOfSums);

        System.out.println(squareOfSums - sumOfSquares);

    }


}
