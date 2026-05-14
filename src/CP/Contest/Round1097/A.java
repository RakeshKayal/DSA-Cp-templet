package CP.Contest.Round1097;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }


            for (int i = n - 2; i >= 0; i--) {
                if (a[i + 1] >= 0) {
                    a[i] += a[i + 1];
                }
            }

            int c = 0;
            for (long val : a) {
                if (val > 0) c++;
            }

            out.println(c);
        }

        out.flush();
    }
}