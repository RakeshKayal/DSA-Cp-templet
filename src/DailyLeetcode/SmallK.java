package DailyLeetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SmallK {
    public static void main(String[] args) {

    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0;
        int hi = nums[n - 1] - nums[0];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;


            if (countPairs(nums, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
