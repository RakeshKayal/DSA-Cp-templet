package CP.Graph;

import java.io.*;
import java.util.*;

public class HowManyPaths {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int n;
    static List<List<Integer>> g;
    static Set<Integer>[] s = new HashSet[2];

    static void dfs(int u, int[] color, boolean useS) {
        color[u] = 1;
        for (int v : g.get(u)) {
            if (color[v] == 0)
                dfs(v, color, useS);
            else if (useS)
                s[color[v] - 1].add(v);
        }
        color[u] = 2;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) line = br.readLine();

            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());

            for (int i = 0; i < 2; i++) s[i] = new HashSet<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                g.get(x).add(y);
            }

            int[] color = new int[n];
            dfs(0, color, true);

            int[][] c = new int[2][n];
            for (int i = 0; i < 2; i++)
                for (int u : s[i])
                    dfs(u, c[i], false);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int ans = 0;
                if (color[i] != 0) {
                    ans = 1;
                    if (c[0][i] != 0)
                        ans = -1;
                    else if (c[1][i] != 0)
                        ans = 2;
                }
                sb.append(ans).append(" ");
            }
            out.println(sb.toString().trim());
            out.flush();
        }
    }
}