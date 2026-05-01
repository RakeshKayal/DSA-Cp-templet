package Array;

import java.util.HashMap;
import java.util.Map;

public class StringManupulation {

    public static void main(String[] args) {

        String   s = "leetcode";
        System.out.println(sortVowels(s));
    }
    public static String sortVowels(String s) {
        char[] c = s.toCharArray();

        Map<Character, Integer> f = new HashMap<>();
        for (char ch : c) {
            if ("aeiou".indexOf(ch) != -1) {
                f.put(ch, f.getOrDefault(ch, 0) + 1);
            }
        }

        int fre[]= new int[26];

        for (int i = 0; i < c.length; i++) {
            if ("aeiou".indexOf(c[i]) != -1) {


                int cur= f.containsKey(c[i])? f.get(c[i]):0;
                char max = '$';
                int maxa = -1;
                for (Map.Entry<Character, Integer> entry : f.entrySet()) {
                    if (maxa < entry.getValue()) {
                        maxa = entry.getValue();
                        max = entry.getKey();
                    }
                }


                if (maxa==cur){

                    max= c[i];

                }else {
                    c[i] = max;

                }
                fre[max - 'a']++;
                if (fre[max - 'a'] == f.get(max)) {
                    f.remove(max);
                }

            }
        }

        return new String(c);
    }
}
