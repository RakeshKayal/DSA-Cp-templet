package DailyLeetcode.Weekly;

public class MincostToMove {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(
                minCost(new int[]{-5,-2,3}, new int[][]{{0,2},{2,0},{1,2}})
        )); // [6, 2, 5]

        System.out.println(java.util.Arrays.toString(
                minCost(new int[]{0,2,3,9}, new int[][]{{3,0},{1,2},{2,0}})
        )); // [4, 1, 3]
    }

    public static int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] lomviretas = nums;

        int[] right = new int[n];
        int[] left  = new int[n];



        for (int i = 0; i < n - 1; i++) {
            int leftDiff  = (i == 0) ? Integer.MAX_VALUE : nums[i] - nums[i-1];
            int rightDiff = nums[i+1] - nums[i];

            int cost = (rightDiff < leftDiff) ? 1 : rightDiff;
            right[i+1] = right[i] + cost;
        }


        for (int i = n - 1; i > 0; i--) {
            int leftDiff  = nums[i] - nums[i-1];
            int rightDiff = (i == n-1) ? Integer.MAX_VALUE : nums[i+1] - nums[i];


            int cost = (leftDiff <= rightDiff) ? 1 : leftDiff;
            left[i-1] = left[i] + cost;
        }

        int[] ans = new int[queries.length];
        int qi = 0;
        for (int[] it : queries) {
            int l = it[0];
            int r = it[1];

            if (l < r) {
                ans[qi++] = right[r] - right[l];
            } else if (l > r) {
                ans[qi++] = left[r] - left[l];
            } else {
                ans[qi++] = 0;
            }
        }
        return ans;
    }
}