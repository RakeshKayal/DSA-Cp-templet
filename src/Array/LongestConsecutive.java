package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {

        int nums[]={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {



        Set<Integer> s= new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        int longest=1;
        for (int it : s){

            if (s.contains(it-1)) continue;

            else {
                int x=it;
                int c=1;
                while (s.contains(x+1)){
                    x=x+1;
                    c++;
                }
                longest=Math.max(longest,c);
            }
        }

        return  longest;


    }
}
