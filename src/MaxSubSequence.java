import java.util.Collection;

/**
 * Created by michaelgrimes on 9/10/14.
 */
public class MaxSubSequence {

    public static void main(String[] args) {

        int[] a = {15, -3, 4, 1, 0, -22, 4};

        int j = 0;
        int rightBound = 0;
        int leftBound = 0;
        int maxVal = Integer.MIN_VALUE;
        int tempVal;

        for (int i = 1; i < a.length; i++) {
            tempVal = sum(a, leftBound, i);
            if (tempVal > maxVal) {
                maxVal = tempVal;
                rightBound = i;
            } else if (tempVal < 0) { // if subarray is negative, we know that it can't be part of the max subarray

            }
        }

        System.out.print("Max Subarray is: {");
        for (int i = leftBound; i < rightBound - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[rightBound] + "}");

    }


    public static int sum(int[] a, int left, int right) {

        int sum = 0;
        for (int i = left; i < right; i++) sum += a[i];
        System.out.println("Sum returning " + sum);
        return sum;


    }

}
