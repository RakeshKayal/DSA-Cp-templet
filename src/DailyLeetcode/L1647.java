package DailyLeetcode;

import java.util.HashMap;
import java.util.Map;

public class L1647 {
    public static void main(String[] args) {
        int n[]={1,2,4,3};
        int l=2;

        int i = minMoves(n, l);
        System.out.println(i);

    }
    public static int minMoves(int[] nums, int limit) {

        int n=nums.length;

        Map<Integer,Integer> fre= new HashMap<>();
        int maxFre = -1;
        int targetSum = -1;

        for (int i = 0; i < n/2; i++) {

            int sum= nums[i]+nums[n-1-i];

            fre.put(sum,fre.getOrDefault(sum,0)+1);

            if (fre.get(sum)>maxFre){
                targetSum=sum;
                maxFre=fre.get(sum);
            }
        }


        if (fre.size()==1) return 0;
        int c=0;


        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            if (a + b == targetSum) continue;

            boolean oneMove = (targetSum - a >= 1 && targetSum - a <= limit)
                    || (targetSum - b >= 1 && targetSum - b <= limit);
            c += oneMove ? 1 : 2;
        }
        return  c;

    }
}
