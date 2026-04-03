package DailyLeetcode;

import java.util.Arrays;

public class MaximumWallsDestroyedbyRobots {
    public static void main(String[] args) {
        // do this after launch


        int [] robots = {10,2};
        int [] distance = {5,1};
        int []walls = {5,2,7};


        int n = robots.length;


        int[][] roboDist = new int[n][2];
        for (int i = 0; i < n; i++) {
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }


        Arrays.sort(roboDist, (a, b) -> a[0] - b[0]);

        Arrays.sort(walls);


        int[][] range = new int[n][2];

        for (int i = 0; i < n; i++) {
            int pos = roboDist[i][0];
            int d = roboDist[i][1];

            int leftLimit  = (i == 0) ? 1 : roboDist[i - 1][0] + 1;
            int rightLimit = (i == n - 1) ? (int)1e9 : roboDist[i + 1][0] - 1;

            int L = Math.max(pos - d, leftLimit);
            int R = Math.min(pos + d, rightLimit);

            range[i][0] = L;
            range[i][1] = R;
        }


        int dp[][]= new int[n][2];

        for(int [] row: dp){
            Arrays.fill(row,-1);
        }

        int i = sloveMax(walls, roboDist, range, 0, 0,dp);
        System.out.println(i);


    }

    private static int sloveMax(int[] walls, int[][] roboDist, int[][] range, int i, int prevDir, int[][] dp) {
        if (i == roboDist.length) return 0;

        if (dp[i][prevDir] != -1) return dp[i][prevDir];

        int leftStart = range[i][0];


        if (prevDir == 1 && i > 0) {
            leftStart = Math.max(leftStart, range[i - 1][1] + 1);
        }


        int leftTake = countWalls(walls, leftStart, roboDist[i][0]) +
                sloveMax(walls, roboDist, range, i + 1, 0, dp);


        int rightTake = countWalls(walls, roboDist[i][0], range[i][1]) +
                sloveMax(walls, roboDist, range, i + 1, 1, dp);

        return  dp[i][prevDir]=Math.max(leftTake, rightTake);




    }

    private static int countWalls(int[] walls, int L, int R) {

        int left = lowerBound(walls, L);
        int right = upperBound(walls, R);
        return right - left;

    }

    private static int upperBound(int[] walls, int target) {

        int l = 0, r = walls.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (walls[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private static int lowerBound(int[] walls, int target) {
        int l = 0, r = walls.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (walls[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;

    }
}
