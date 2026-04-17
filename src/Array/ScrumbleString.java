package Array;

import java.util.HashMap;
import java.util.Map;

public class ScrumbleString {


    public static void main(String[] args) {
        String s = "abcde";
        String t = "caebd";

        boolean scramble = isScramble(s, t);
        System.out.println(scramble);
    }

    public static boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);





        int n = s1.length();

        for (int i = 1; i < n; i++) {

            boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i));


            boolean swap = isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i));

            if (noSwap || swap) {

                return true;
            }
        }


        return false;
    }
}