package Practice.TwoPointer;

public class L581 {
    public static void main(String[] args) {

        int nums[]={2,6,4,8,9,10,15};

        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);


    }
    public static int findUnsortedSubarray(int[] nums) {


        int n=nums.length;

        int maxSeen = Integer.MIN_VALUE;
        int minSeen = Integer.MAX_VALUE;

        int left=-1;
        int right=-1;

        for (int i = 0; i < n; i++) {

            maxSeen=Math.max(maxSeen,nums[i]);

            if (nums[i]<maxSeen) right=i;
            minSeen = Math.min(minSeen, nums[n - 1 - i]);
            if (nums[n - 1 - i] > minSeen) left = n - 1 - i;




        }
        return right == -1 ? 0 : right - left + 1;

    }
}
