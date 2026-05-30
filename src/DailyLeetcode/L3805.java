package DailyLeetcode;

import java.util.*;

public class L3805 {
    public static void main(String[] args) {

        String  word[]={"ab","aa","za","aa"};
        System.out.println(countPairs(word));

    }
    public static long countPairs(String[] words) {
        Map<String, Long> freq = new HashMap<>();
        for (String w : words) {
            String key = normalize(w);
            freq.merge(key, 1L, Long::sum);
        }
        long count = 0;
        for (long f : freq.values()) {
            count += f * (f - 1) / 2;
        }
        return count;
    }

    private static String normalize(String w) {
        StringBuilder sb = new StringBuilder();
        char base = w.charAt(0);
        for (char c : w.toCharArray()) {
            sb.append((char)(((c - base + 26) % 26) + 'a'));
        }
        return sb.toString();
    }
}
