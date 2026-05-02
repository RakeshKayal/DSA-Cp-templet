package CSES.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] e = new int[n - 1];
        for (int i = 0; i < e.length; i++) {
            e[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> adj = new ArrayList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = e[i] - 1;
            int v = i + 1;
            adj.get(u).add(v);
        }


        int[] stack = new int[n];
        int[] order = new int[n];
        int top = 0, idx = 0;

        stack[top++] = 0;
        while (top > 0) {
            int node = stack[--top];
            order[idx++] = node;
            for (int child : adj.get(node)) {
                stack[top++] = child;
            }
        }


        for (int i = idx - 1; i >= 0; i--) {
            int node = order[i];
            dp[node] = 0;
            for (int child : adj.get(node)) {
                dp[node] += 1 + dp[child];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dp[i]).append(' ');
        }
        out.print(sb);
        out.flush();
    }
}