package CodeForces.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Mini {
    public static void main(String[] args) {


        int [][] grid={
                {3,4,2,1},
                {4,2,1,1},
                {2,1,1,0},
                {3,4,1,0}
        };
        int i = minimumVisitedCells(grid);
        System.out.println(i);
    }
    public static int minimumVisitedCells(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        class Pair {
            int row, col, step;
            Pair(int row, int col, int step) {
                this.row = row;
                this.col = col;
                this.step = step;
            }
        }

        TreeSet<Integer>[] rowSets = new TreeSet[n];
        TreeSet<Integer>[] colSets = new TreeSet[m];

        for (int r = 0; r < n; r++) rowSets[r] = new TreeSet<>();
        for (int c = 0; c < m; c++) colSets[c] = new TreeSet<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                rowSets[r].add(c);
                colSets[c].add(r);
            }
        }

        // Remove starting cell
        rowSets[0].remove(0);
        colSets[0].remove(0);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.step - b.step);
        pq.add(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int step = curr.step;
            int value = grid[r][c];

            if (r == n - 1 && c == m - 1) return step;


            List<Integer> eraseCols = new ArrayList<>(
                    rowSets[r].subSet(c + 1, true, c + value, true)  // ← range query
            );
            for (int col : eraseCols) {
                pq.add(new Pair(r, col, step + 1));
                rowSets[r].remove(col);
                colSets[col].remove(r);
            }


            List<Integer> eraseRows = new ArrayList<>(
                    colSets[c].subSet(r + 1, true, r + value, true)  // ← range query
            );
            for (int row : eraseRows) {
                pq.add(new Pair(row, c, step + 1));
                colSets[c].remove(row);
                rowSets[row].remove(c);
            }
        }

        return -1;
    }
}
