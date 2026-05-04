package DailyLeetcode.Weekly;

import java.util.*;

public class MaximizePoint {
    public static void main(String[] args) {

        int [] nu={1,0,1,2};
        System.out.println(maxFixedPoints(nu));

    }
    public static int maxFixedPoints(int[] nums) {


        int n=nums.length;
        if (n==0) return  0;
        if (n==1) return  nums[0]==0 ?1 :0;


        List<int[]> v= new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (nums[i]<=i){
                v.add(new int[]{i-nums[i],nums[i]});
            }
        }


        Collections.sort(v, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);


        List<Integer> a= new ArrayList<>();

        for(int i[] :v){
            int n1=i[1];
            a.add(n1);

        }

        int dp[][]= new int[n][n+1];
        for (int[] row :dp){
            Arrays.fill(row,-1);
        }


        int lis = LIS(0, -1, a,dp);

        return lis;

    }

    private static int LIS(int i, int pre, List<Integer> v, int[][] dp) {

        if (i==v.size()){
            return 0;
        }

        if (dp[i][pre+1]!= -1) return  dp[i][pre+1];

        int notTake= LIS(i+1,pre,v, dp);
        int take=0;
        if (pre==-1 ||v.get(pre) < v.get(i)){
            take=1+LIS(i+1,i,v, dp);
        }
        return dp[i][pre+1]=  Math.max(take,notTake);
    }
}
