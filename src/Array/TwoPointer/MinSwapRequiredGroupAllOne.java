package Array.TwoPointer;

public class MinSwapRequiredGroupAllOne {
    public static void main(String[] args) {
        int nums[]={1, 0, 1, 0, 1};

        int n=nums.length;


        int totalOnes = 0;
        for (int x : nums) {
            if (x == 1) totalOnes++;
        }

        if (totalOnes == 0 ) {
            System.out.println(-1);
            return;
        }
        if (totalOnes == n){
            System.out.println(0);
            return;
        }
        int zeros = 0;
        for (int k = 0; k < totalOnes; k++) {
            if (nums[k] == 0) zeros++;
        }

        int minSwaps = zeros;


        for (int k = totalOnes; k < n; k++) {
            if (nums[k] == 0) zeros++;
            if (nums[k - totalOnes] == 0) zeros--;
            minSwaps = Math.min(minSwaps, zeros);
        }

        System.out.println(minSwaps);  //O(n) and sp-> O(1) and it pass 10^5 tc

    }
}
