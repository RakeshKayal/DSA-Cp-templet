package DailyLeetcode;

public class MaxPathScore {
    public static void main(String[] args) {

    }
    public  static int maxPathScore(int[][] grid, int k) {




        return  solvegrid(0,0,0,grid,k);

    }

    private static int solvegrid(int i, int j, int cost, int[][] grid, int k) {

        if (i>=grid.length || j>=grid[0].length) return  -1;
        if (i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if (cost>k){
            return -1;
        }

        int  c=grid[i][j]==0?0:1;
        int right= grid[i][j]+ solvegrid(i,j+1,cost+c,grid,k);
        int down= grid[i][j]+solvegrid(i+1,j,cost+c,grid,k);

        return  Math.max(right,down);


    }
}
