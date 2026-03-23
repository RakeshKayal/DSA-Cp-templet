package DailyLeetcode;


//**1594//
public class MaximumNonNegativeProductMatrix {
    public static void main(String[] args) {

        int [][] grid={
                {1,3},
                {0,-4},

        };

        int i = maxProductPath(grid);
        System.out.println(i);


    }
    static  int MOD=(int)1e9+7;

    public  static  int maxProductPath(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        long [][][] dp  = new long [n][m][2]; // 2 beacuse of stroe max and min
        //max=0
        // min=1   for 2 cell

        for(long [][] it: dp){
            for(long[] c: it){
                c[0]=Long.MIN_VALUE; //max
                c[1]=Long.MAX_VALUE; //min

            }
        }


        long[] slove = slove(n - 1, m - 1, grid,dp);

        long res=slove[0];
        if (res<0) return -1;

        return (int) (res % MOD);

    }

    private static long[] slove(int i, int j, int[][] grid, long[][][] dp) {


        if(i==0 && j==0){
            return  new long[]{grid[0][0],grid[0][0]};
        }

        if (dp[i][j][0] != Long.MIN_VALUE) {  // as i only want max
            return dp[i][j];
        }

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;


        if (i>0){
            long[]up= slove(i-1,j,grid,dp);
            long prod1 = up[0] * grid[i][j];
            long prod2 = up[1] * grid[i][j];
            max = Math.max(max, Math.max(prod1, prod2));
            min = Math.min(min, Math.min(prod1, prod2));
        }
        if (j>0){
            long [] left=slove(i,j-1,grid,dp);
            long prod1 = left[0] * grid[i][j];
            long prod2 = left[1] * grid[i][j];
            max = Math.max(max, Math.max(prod1, prod2));
            min = Math.min(min, Math.min(prod1, prod2));

        }

        dp[i][j][0] = max;
        dp[i][j][1] = min;



        return dp[i][j];  // with memo it take O(n*m)  space ->O(n + m)
    }  // without memoization it take ~O(2^(n+m)) exponential space-> ~O(2^(n+m)) recursion stack space

}
