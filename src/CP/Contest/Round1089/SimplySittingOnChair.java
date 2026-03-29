package CP.Contest.Round1089;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimplySittingOnChair {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            arr = new int[n + 1];
            dp = new int[n + 1];
            Arrays.fill(dp, -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            out.println(solve(1, n));
        }
        out.flush();
    }

    static int solve(int i, int n) {
        if (i > n) return 0;

        if (dp[i] != -1) return dp[i];

        int skip = solve(i + 1, n);

        int sit = 0;
        if (arr[i] <= i) {
            sit = 1 + solve(i + 1, n);
        }

        return dp[i] = Math.max(sit, skip);
    }
}