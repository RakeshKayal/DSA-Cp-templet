package CP.Contest.Round1093;

import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] first = br.readLine().trim().split(" ");
            int n = Integer.parseInt(first[0]);
            long m = Long.parseLong(first[1]);

            String[] arr = br.readLine().trim().split(" ");

            Set<Long> forbidden = new HashSet<>();

            for (int i = 1; i <= n; i++) {
                long ai = Long.parseLong(arr[i - 1]);

                long bad = ((-(ai + i)) % m + m) % m;
                forbidden.add(bad);
            }

            if (forbidden.size() < m) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}