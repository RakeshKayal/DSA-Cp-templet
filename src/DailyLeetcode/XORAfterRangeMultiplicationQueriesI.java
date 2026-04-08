package DailyLeetcode;

public class XORAfterRangeMultiplicationQueriesI {
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


        for(int it[] :queries){

            int l=it[0];
            int r=it[1];
            int k=it[2];
            int v=it[3];

            int idx=l;
            while (idx<=r){
                nums[idx]=(nums[idx]*v)%mod;
                idx+=k;
            }

        }


        int xor=0;
        for (int num : nums) {
            xor^=num;
        }
        return xor;



    }
}
