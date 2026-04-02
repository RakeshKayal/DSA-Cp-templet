package DailyLeetcode;

public class MaximumAmountMoneyRobotCanEarn {
    public static void main(String[] args) {


        int mat[][]={

                {10,10,10},
                {10,10,10},

        };

        int i = maximumAmount(mat);
        System.out.println(i);

    }

    public static int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        return solve1(0, 0, coins, n - 1, m - 1, 2); // start with 2 allowed skips
    }

    private static int solve1(int i, int j, int[][] coins, int n, int m, int neutralize) {


        if (i > n || j > m) return Integer.MIN_VALUE;


        if (i == n && j == m) {
            if (coins[i][j] < 0 && neutralize > 0) {
                return 0;
            }
            return coins[i][j];
        }

        int right = solve1(i, j + 1, coins, n, m, neutralize);
        int down  = solve1(i + 1, j, coins, n, m, neutralize);
        int max   = Math.max(right, down);

        if (coins[i][j] < 0) {
            if (neutralize > 0) {

                int skipRight = solve1(i, j + 1, coins, n, m, neutralize - 1);
                int skipDown  = solve1(i + 1, j, coins, n, m, neutralize - 1);
                int skipMax   = Math.max(skipRight, skipDown);

                return Math.max(skipMax, max + coins[i][j]);
            } else {
                return max + coins[i][j];
            }
        }

        return max + coins[i][j];
    }
}
