package DailyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class JumpIX {
    public static void main(String[] args) {


        int n[] = {2, 1, 3};
        int[] ints = maxValue(n);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

    }

    public static int[] maxValue(int[] nums) {

        int n = nums.length;
        int min[] = new int[n];
        min[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            min[i] = Math.min(min[i + 1], nums[i]);

        }
        int max[] = new int[n];

        max[0] = nums[0];

        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
        }


        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max[i];

            if (i + 1 < n && min[i + 1] < max[i]) {
                ans[i] = ans[i + 1];
            }
        }
        return ans;


    }
}
