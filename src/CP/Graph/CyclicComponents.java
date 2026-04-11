package CP.Graph;

import java.io.*;
import java.util.*;

public class CyclicComponents {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int n, m;
    static int[] deg;
    static boolean[] used;
    static List<List<Integer>> g;
    static List<Integer> comp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        deg = new int[n];
        used = new boolean[n];
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            g.get(x).add(y);
            g.get(y).add(x);
            deg[x]++;
            deg[y]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                comp = new ArrayList<>();
                dfs(i);
                boolean ok = true;
                for (int v : comp) ok = ok && deg[v] == 2;
                if (ok) ans++;
            }
        }

        out.println(ans);
        out.flush();
    }

    static void dfs(int v) {
        used[v] = true;
        comp.add(v);
        for (int to : g.get(v)) {
            if (!used[to]) dfs(to);
        }
    }
}