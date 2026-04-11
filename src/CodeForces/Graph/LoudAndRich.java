package CodeForces.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LoudAndRich {
    public static void main(String[] args) {

        int [][]richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int []quiet = {3,2,5,4,6,1,7,0};

        int[] ints = loudAndRich(richer, quiet);

        for (int i = 0; i < ints.length; i++) {

            System.out.print(ints[i]+" ");
        }

    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        int[] ind = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] it : richer) {
            int u = it[0]; // u is richer than v
            int v = it[1];
            ind[v]++;
            adj.get(u).add(v);
        }

        // Initialize every node as its own answer
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = i;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                // Propagate: if node's quietest is quieter than neighbor's current best
                if (quiet[ans[node]] < quiet[ans[neighbor]]) {
                    ans[neighbor] = ans[node];
                }
                ind[neighbor]--;
                if (ind[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }
}
