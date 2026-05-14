package DailyLeetcode.Weekly501;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidWordOccurance {
    public static void main(String[] args) {

        String  [] chunks = {"m  cq-i "};

        String [] queries = {"m","cq-i","nm"};
        int[] ints = countWordOccurrences(chunks, queries);
        for( int i: ints){
            System.out.print(i+ " ");
        }


    }
        public static int[] countWordOccurrences(String[] chunks, String[] queries) {

            StringBuilder sb = new StringBuilder();
            for (String chunk : chunks) sb.append(chunk);
            String s = sb.toString();

            Map<String, Integer> freq = new HashMap<>();
            Matcher matcher = Pattern.compile("[a-z]+(-[a-z]+)*").matcher(s);
            while (matcher.find()) {
                String word = matcher.group();
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }

            // Step 3: Answer queries
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = freq.getOrDefault(queries[i], 0);
            }
            return ans;
        }

}
