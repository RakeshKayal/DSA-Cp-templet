package Array;

import java.util.Arrays;
import java.util.Collections;

public class minOperation {
    public static void main(String[] args) {

        int arr[]={3,3,2,1};
        System.out.println(minOperations(arr));
    }

    public static long minOperations(int[] nums) {


        int n= nums.length;


        int max=nums[0];
        int ind=0;
        for (int i = 1; i <n ; i++) {

            if (max<nums[i]){
                max=nums[i];
                ind=i;
            }
        }

        int[] ints = Arrays.copyOfRange(nums, 0, ind );
        int[] ints1 = Arrays.copyOfRange(nums, ind +1, n);
        Arrays.sort(ints1);
        Arrays.sort(ints);

        long sum=0;
        sum += (ints.length > 0)  ? max - ints[0]  : 0;
        sum += (ints1.length > 0) ? max - ints1[0] : 0;

        return  sum;


    }
}
