import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if ((a + b) % 3 == 0 && a <= 2 * b && b <= 2 * a) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);


    }

//    private static boolean valid(int f, int s) {
//
//        if (f==0 && s==0) return  true;
//        if (f==0 || s==0) return false;
//        if (f<0 || s<0) return false;
//
//        boolean first= valid(f-2,s-1);
//        boolean second= valid(f-1,s-2);
//
//        return  first || second;
//
//    }

//    static int[] dr = {-1, 1, 0, 0};
//    static int[] dc = {0, 0, -1, 1};
//
//    private static int countRoom(char[][] a) {
//
//        int n = a.length;
//        int m = a[0].length;
//        boolean[][] visit = new boolean[n][m];
//        int c = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (a[i][j] == '.' && !visit[i][j]) {
//                    c++;
//                    // Iterative DFS
//                    Deque<int[]> stack = new ArrayDeque<>();
//                    stack.push(new int[]{i, j});
//                    visit[i][j] = true;
//
//                    while (!stack.isEmpty()) {
//                        int[] cur = stack.pop();
//                        int r = cur[0], col = cur[1];
//
//                        for (int k = 0; k < 4; k++) {
//                            int nr = r + dr[k];
//                            int nc = col + dc[k];
//
//                            if (nr >= 0 && nr < n && nc >= 0 && nc < m
//                                    && !visit[nr][nc] && a[nr][nc] == '.') {
//                                visit[nr][nc] = true;
//                                stack.push(new int[]{nr, nc});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return c;
//    }
}