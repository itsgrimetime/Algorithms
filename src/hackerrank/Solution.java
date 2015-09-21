package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        while (scanner.hasNextInt()) {
            pq.add(scanner.nextInt());
        }

        int min = pq.poll();
        int max = 0;

        for (int i = 0; i < k - 1; i++) {
            max = pq.poll();
        }

        System.out.println(max - min);

    }
}