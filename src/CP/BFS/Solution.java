package CP.BFS;

import java.util.*;

class Solution {
    static final int N = 21;
    static int n, m, half;
    static long k, sol;
    static long[][] g = new long[N][N];
    static Map<Long, Integer>[][] solutions = new HashMap[N][N];

    static void firstHalf(int i, int j, long val, int cnt) {
        val ^= g[i][j];
        if (cnt == half) {
            solutions[i][j].merge(val, 1, Integer::sum);
            return;
        }
        if (i + 1 < n) firstHalf(i + 1, j, val, cnt + 1);
        if (j + 1 < m) firstHalf(i, j + 1, val, cnt + 1);
    }

    static void secondHalf(int i, int j, long val, int cnt) {
        if (cnt == (m + n - 2) - half) {
            long target = val ^ k;
            if (solutions[i][j].containsKey(target)) {
                sol += solutions[i][j].get(target);
            }
            return;
        }
        val ^= g[i][j];
        if (i > 0) secondHalf(i - 1, j, val, cnt + 1);
        if (j > 0) secondHalf(i, j - 1, val, cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextLong();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = sc.nextLong();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                solutions[i][j] = new HashMap<>();

        half = (n + m - 2) / 2;
        firstHalf(0, 0, 0, 0);
        secondHalf(n - 1, m - 1, 0, 0);

        System.out.println(sol);
    }
}