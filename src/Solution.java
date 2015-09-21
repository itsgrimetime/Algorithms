import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner("cdefghmnopqrstuvw");
        String inputString = myScan.nextLine();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : inputString.toCharArray()) {
            if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
            System.out.println(ch + " : " + map.get(ch));
        }

        String ans = "YES";

        if (inputString.length() % 2 != 0) {
            System.out.println("string is odd length");
            boolean foundOne = false;
            for (int i : map.values()) {
                if (i % 2 != 0) {
                    if (foundOne) {
                        ans = "NO";
                    } else {
                        foundOne = true;
                    }
                }
            }
        } else {
            for (int i : map.values()) {
                if (i % 2 != 0) {
                    ans = "NO";
                }
            }
        }

        System.out.println(ans);
        myScan.close();
    }
}

