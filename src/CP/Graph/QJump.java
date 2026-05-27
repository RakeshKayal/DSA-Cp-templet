package CP.Graph;

import java.io.*;
import java.util.*;

public class QJump {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t= Integer.parseInt(br.readLine());

        while (t-->0){


            StringTokenizer st= new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int q= Integer.parseInt(st.nextToken());

            int a[][]= new int[q+1][2];

            for (int i = 0; i < q; i++) {
                st= new StringTokenizer(br.readLine());
                int u= Integer.parseInt(st.nextToken());
                int v= Integer.parseInt(st.nextToken());
                a[i][0]=u;
                a[i][1]=v;

            }

            List<List<Integer>> adj= new ArrayList<>();
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

            for (int i = 1; i <=n ; i++) {

                for (int j = i+1; j <=n; j++) {

                    if(isEdge(Math.abs(j-i))){
                        adj.get(i).add(j);
                        adj.get(j).add(i);
                    }
                }
            }


            for (int i = 0; i < q; i++) {
                int src = a[i][0];
                int des = a[i][1];

                int dijsktra = dijkstra(src, des, adj, n);
                out.println(dijsktra);
                out.flush();
            }

        }

    }

    private static int dijkstra(int src, int des, List<List<Integer>> adj, int n) {
        int[] dist = new int[n + 1];  // n+1, not n
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            if (node == des) return d;
            if (d > dist[node]) continue;  // stale entry, skip

            for (int neighbor : adj.get(node)) {
                if (d + 1 < dist[neighbor]) {
                    dist[neighbor] = d + 1;
                    pq.add(new int[]{neighbor, d + 1});
                }
            }
        }
        return -1;
    }

    private static boolean isEdge(int abs) {


        if (abs==1) return true;

        for (int i = 2; i*i<=abs ; i++) {

            if (i*i==abs) return  true;
        }
        return  false;
    }
}
