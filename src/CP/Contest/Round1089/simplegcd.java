package CP.Contest.Round1089;

import java.io.*;

public class simplegcd {
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int nextInt() throws Exception { in.nextToken(); return (int) in.nval; }

    static long gcd(long a, long b) { while (b != 0) { long t = b; b = a % b; a = t; } return a; }
    static long lcm(long a, long b) {
        long g = gcd(a, b);
        // Guard against overflow: if lcm would exceed Long.MAX_VALUE, cap it
        if (a / g > Long.MAX_VALUE / b) return Long.MAX_VALUE;
        return a / g * b;
    }

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            for (int i = 0; i < n; i++) nextInt();

            int ops = 0;
            for (int i = 0; i < n; i++) {
                long lval;
                if (i == 0)       lval = a[1];           // only right neighbor
                else if (i == n-1) lval = a[n-2];         // only left neighbor
                else               lval = lcm(a[i-1], a[i+1]); // both neighbors

                if (lval % a[i] != 0) ops++;
            }

            out.println(ops);
        }
        out.flush();
    }
}