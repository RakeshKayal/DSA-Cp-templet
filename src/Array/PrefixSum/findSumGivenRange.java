package Array.PrefixSum;

public class findSumGivenRange {
    public static void main(String[] args) {
        int []nums = {1, 2, 3, 4, 5, 6};
        int [][] range={
                {1,3},
                {3,5},
                {0,3},
                {0,5}
        } ;// range
        // output should be  2+3+4 =9;
        // let's you are given n no of range
        // it take a lot time to calculate the sum
        // by evertime running the loop
        // while(i<=j) s+= a[i]; // some thing like this


        // what i do calculate  cumulative sum first

        int pref[]=new int[nums.length];

        pref[0]= nums[0];

        for (int k = 1; k <nums.length ; k++) {

            pref[k]= pref[k-1]+nums[k];
        }

        // to do the range if i know upto j sum and - it with i-1 i will find the ans
        // edge  i  must > 0 if it is 0  then only return pref[j]


        for (int[] ints : range) {
            int s=ints[0];
            int e=ints[1];
            if (s==nums.length || e== nums.length) System.out.println(pref[pref.length-1]);

            if(s==0) {
                System.out.println(pref[e]);
            }else{
                System.out.println(pref[e]-pref[s-1]);
            }
        }


    }
}
