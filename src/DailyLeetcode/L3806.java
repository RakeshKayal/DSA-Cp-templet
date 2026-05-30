package DailyLeetcode;

import java.util.Arrays;

public class L3806 {
    public static void main(String[] args) {

            int nums[]={1,2,8,4};
            int k=7;
            int m=3;
        System.out.println(maximumAND(nums,k,m));


    }
    public static int maximumAND(int[] nums, int k, int m) {

        Arrays.sort(nums);
        int i=0;
        int j=0;
        int n= nums.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        

        while (j<n){
            sum+=nums[j];

            while (j - i + 1 > m) {
                sum -= nums[i];
                i++;
            }
            
            if (j-i+1==m){
                System.out.println("sum=" + sum + " num=" + nums[j]);
                int max1 = findMax(m, sum, k,nums[j]);
                max=Math.max(max1,max);
            }
            j++;


        }
        return  max;

    }

    private static int findMax(int m, int sum, int k, int num) {


        long l= num;
        long h= num+k;
        long res=0;

        while (l<=h){

            long mid = l + (h - l) / 2;
            long with_mid=mid*m;
            long extra=with_mid-sum;
            if (extra>=0 && extra<=k){

                res=mid;
                l=mid+1;
            }else {
                h=mid-1;
            }


        }

        return (int)res;
    }
}
