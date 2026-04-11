package DailyLeetcode;

import java.util.*;

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

        Map<Integer,List<int[]>> m= new HashMap<>();

        for(int it[] :queries) {

            int l = it[0];
            int r = it[1];
            int k = it[2];
            int v = it[3];

            if (k<t){

                m.put(k, new ArrayList<>());
                m.get(k).add(new int[]{l,r,v});
            }
            else {
                for (int i = l; i <r ; i+=k) {
                    nums[i]=(int)(((long) nums[i] *v)%mod);
                }
            }
        }

        for (Map.Entry<Integer, List<int[]>> integerEntry : m.entrySet()) {


            int k= integerEntry.getKey();
            List<int[]> value = integerEntry.getValue();
            long diff[]= new long[n];
            Arrays.fill(diff,1);

           for( int it [] :value){
               int s= it[0];
               int e=it[1];
               int v=it[2];

               diff[s]=(diff[s]*v)%mod;
               int step=(e-s)/k;
               int next=s+(step+1)*k;

               if (next<n){
                   diff[next]=(diff[next]*power(v,mod-2))%mod ;
               }
           }

            for (int i = 1; i < diff.length; i++) {
                diff[i]=(diff[i]*diff[i-k])%mod;
            }

            for (int i = 0; i < n; i++) {
                nums[i]=(int) (nums[i]*diff[i])%mod;
            }

        }

        int xor=0;
        for (int i = 0; i < n; i++) {
            xor^=nums[i];

        }


        return xor;

    }
     static  long power(long a, long b) {
        long result = 1;
        a = a % mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }
}
