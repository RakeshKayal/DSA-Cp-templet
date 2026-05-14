package DailyLeetcode;

import java.util.Arrays;

public class L3629 {
    public static void main(String[] args) {


        int n[]= {7,5,7};

        System.out.println(minJumps(n));

    }
    public static int minJumps(int[] nums) {

        int[] primes= getPrime((int)1e6);
        int n= nums.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);

        return  solveMinJump(0,primes,nums,dp);

    }

    private static int solveMinJump(int ind, int[] primes, int[] nums, int[] dp) {
        if (ind == nums.length - 1) return 0;
        if (dp[ind] != -1) return dp[ind];


        int result = 1 + solveMinJump(ind + 1, primes, nums, dp);


        if (primes[nums[ind]] == 1) {
            for (int i = ind + 2; i < nums.length; i++) {
                if (nums[i] % nums[ind] == 0) {
                    System.out.println("Prime jump from " + ind + " to " + i);
                    result = Math.min(result, 1 + solveMinJump(i, primes, nums, dp));
                }
            }
        }

        return dp[ind] = result;
    }



    private static int[] getPrime(int n) {


        int[] p = new int[n+1];

        for (int i = 0; i <= n; i++) p[i]=1;
        p[0] = 0;
        p[1] = 0;
        for (int i = 2; i*i <=n ; i++) {

            if (p[i]==1){
                for (int j = i*i; j <=n ; j++) {

                    p[j]=0;
                }
            }
        }
        return  p;
    }
}
