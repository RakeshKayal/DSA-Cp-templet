package Array.PrefixSum;

public class findSumGivenRange {
    public static void main(String[] args) {
        int []nums = {1, 2, 3, 4, 5, 6};
        int i = 1, j = 3; // range
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

        System.out.println(pref[j]-pref[i-1]);


    }
}
