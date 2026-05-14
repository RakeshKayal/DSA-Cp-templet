package Practice.TwoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L31 {
    public static void main(String[] args) {

        int nums[]={1,3,2};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {

        int n=nums.length;

        boolean reve = reve(nums);
        if (reve){
            Arrays.sort(nums);
        }else {

            if (nums[n-1]>nums[n-2]){

                int temp= nums[n-1];
                nums[n-1]=nums[n-2];
                nums[n-2]=temp;
            }
            else {
                int temp= nums[0];
                for (int i = 0; i < n-1; i++) {
                    nums[i]=nums[i+1];
                }
                nums[n-1]=temp;
            }
        }

        printfs(nums);
    }

    private static void printfs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            System.out.print(nums[i]+" ");
        }
    }

    private static boolean reve(int[] nums) {


        for (int i = 1; i <nums.length ; i++) {

            if (nums[i-1]<nums[i]) return  false;
        }
        return  true;

    }
}
