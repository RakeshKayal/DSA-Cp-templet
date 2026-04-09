package DailyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class XORAfterRangeMultiplicationQueriesII {

    public static void main(String[] args) {
        int [] nums={2,3,1,5,4};
        int [][] q= {
                {1,4,2,3},
                {0,2,1,2}
        };
        int i = xorAfterQueries(nums, q);
        System.out.println(i);

    }
    static  int mod=(int)1e9+7;
    public  static int xorAfterQueries(int[] nums, int[][] queries) {


        int n= nums.length;
        int t=(int)Math.sqrt(n);

        List<List<int[]>> group= new ArrayList<>();

        for(int it[] :queries) {

            int l = it[0];
            int r = it[1];
            int k = it[2];
            int v = it[3];

            if (k<t){

                group.get(k).add(new int[]{l,r,v});
            }
            else {
                for (int i = l; i <r ; i+=k) {
                    nums[i]=(int)(((long) nums[i] *v)%mod);
                }
            }
        }

        return 0;

    }
}
