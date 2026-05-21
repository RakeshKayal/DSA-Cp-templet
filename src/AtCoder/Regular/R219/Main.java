package AtCoder.Regular.R219;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s = new String[n];
        Map<String, Integer> mp = new HashMap<>();
        int ret = 0;

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            if (mp.getOrDefault(s[i], 0) == 0) {
                mp.put(s[i], 1);
                ret++;
            }
        }

        int mm = 1 << m;
        if (m < 20 && ret >= mm) {
            out.println("No");
        } else {
            out.println("Yes");
            for (int i = 0; i <= n; i++) {
                StringBuilder ss = new StringBuilder();
                int tmp = i;
                for (int j = 0; j < m; j++) {
                    ss.append(tmp % 2 == 0 ? '1' : '0');
                    tmp /= 2;
                }
                if (mp.getOrDefault(ss.toString(), 0) == 0) {
                    for (char c : ss.toString().toCharArray()) {
                        out.print(c == '0' ? '1' : '0');
                    }
                    out.println();
                    break;
                }
            }
        }
        out.flush();
    }
}