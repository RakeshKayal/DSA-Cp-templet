package CP.Graph;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TwoButtons {

    static BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        // it can go blue or red b->subtract by 1 r-> multiply by 2;

        int slovebfs = slovebfs(n, m);
        out.println(slovebfs);
        out.flush();


    }

    private static int slovebfs(int n, int m) {

        if (n >= m) return n - m;

        class pari {
            int node, step;
            pari(int node, int step) {
                this.node = node;
                this.step = step;
            }
        }

        int LIMIT = 2 * m; // can overshoot, but no point going beyond 2*m
        boolean[] visited = new boolean[LIMIT + 1];
        PriorityQueue<pari> pq = new PriorityQueue<>((a, b) -> a.step - b.step);
        pq.add(new pari(n, 0));

        while (!pq.isEmpty()) {
            pari p = pq.poll();
            int node = p.node;
            int step = p.step;

            if (node <= 0 || node > LIMIT || visited[node]) continue;
            visited[node] = true;

            if (node == m) return step;

            // Red: multiply by 2 (allow overshoot up to LIMIT)
            int red = node * 2;
            if (red <= LIMIT) pq.add(new pari(red, step + 1));

            // Blue: subtract 1
            int blue = node - 1;
            if (blue > 0) pq.add(new pari(blue, step + 1));
        }

        return -1;
    }
}
