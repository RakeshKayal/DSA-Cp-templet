package CodeForces.Graph;

import java.util.*;

public class ValidPath {
    public static void main(String[] args) {

        int[][] g = {
                {2, 4, 3},
                {6, 5, 2}
        };
        System.out.println(hasValidPath(g));
    }

    public static boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Map<Integer, List<int[]>> map = new HashMap<>() {{
            put(1, new ArrayList<>(Arrays.asList(new int[]{0,-1}, new int[]{0,1})));
            put(2, new ArrayList<>(Arrays.asList(new int[]{-1,0}, new int[]{1,0})));
            put(3, new ArrayList<>(Arrays.asList(new int[]{0,-1}, new int[]{1,0})));
            put(4, new ArrayList<>(Arrays.asList(new int[]{0,1},  new int[]{1,0})));
            put(5, new ArrayList<>(Arrays.asList(new int[]{0,-1}, new int[]{-1,0})));
            put(6, new ArrayList<>(Arrays.asList(new int[]{0,1},  new int[]{-1,0})));
        }};

        int[][] visit = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visit[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            if (r == n-1 && c == m-1) return true;


            for (int[] dir : map.get(grid[r][c])) {
                int nr = r + dir[0], nc = c + dir[1];


                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visit[nr][nc] == 1) continue;


                boolean connected = false;
                for (int[] nd : map.get(grid[nr][nc])) {
                    if (nr + nd[0] == r && nc + nd[1] == c) {
                        connected = true;
                        break;
                    }
                }

                if (connected) {
                    visit[nr][nc] = 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
