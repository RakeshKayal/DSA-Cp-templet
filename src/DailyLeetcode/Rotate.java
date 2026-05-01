package DailyLeetcode;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {

        int num[]={4,3,2,6};

        System.out.println(maxRotateFunction(num));

    }
    static  int max;


    public static int maxRotateFunction(int[] nums) {
        max = Integer.MIN_VALUE;
        int n = nums.length;


        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);


        max = Math.max(max, value(nums));
        memo[0] = max;


        solveRotate(nums, 1, memo);

        return max;
    }

    private static void solveRotate(int[] nums, int k, int[] memo) {
        int n = nums.length;


        if (k == n) return;


        if (memo[k] != Integer.MIN_VALUE) {
            max = Math.max(max, memo[k]);
            return;
        }


        int[] rotated = rotate(nums, k);
        int val = value(rotated);


        memo[k] = val;
        max = Math.max(max, val);


        solveRotate(nums, k + 1, memo);
    }


    public static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int k1 = k % n;


        int[] result = nums.clone();

        reverseArray(result, 0, n - 1);
        reverseArray(result, 0, k1 - 1);
        reverseArray(result, k1, n - 1);

        return result;
    }

    private static void reverseArray(int[] arr, int i, int k) {
        while (i < k) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
            k--;
        }
    }

    public  static int value(int nums[]){

        int ans=0;
        for (int i = 0; i <nums.length ; i++) {

            int res=i* nums[i];
            ans+=res;

        }
        return ans;
    }
}
