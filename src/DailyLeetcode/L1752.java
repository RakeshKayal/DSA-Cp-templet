package DailyLeetcode;

import java.util.Arrays;

public class L1752 {
    public static void main(String[] args) {

        int n[]={2,1,3,4};
        System.out.println(check(n));
    }

    public  static boolean check(int[] nums){


        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);


        int n= nums.length;

        for (int i = 0; i <=n; i++) {

            if (CanSorts(nums,ints,i)) return true;
        }
        return false;


    }

    private static boolean CanSorts(int[] nums, int[] ints, int x) {


        for (int i = 0; i < nums.length; i++) {

            int a= (x+i)%nums.length;

            if (nums[i]!=ints[a]) return  false;
        }
        return  true;
    }
}
