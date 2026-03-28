package CP;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int n = 5, m = 5;
        int[][] arr = new int[n][m];
        int sRow = 0, sCol = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    sRow = i;
                    sCol = j;
                }
            }
        }


        int moves = Math.abs(sRow - 2) + Math.abs(sCol - 2);

        out.println(moves);
        out.flush();
    }
}