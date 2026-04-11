package DailyLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceBetweenThreeEqualElementsI {
    public static void main(String[] args) {

        int []  nums = {1,2,1,1,3};
        Map<Integer, List<Integer>> m= new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            m.putIfAbsent(nums[i],new ArrayList<>());
            m.get(nums[i]).add(i);
        }
        System.out.println(m);


        int i = minimumDistance(nums);
        System.out.println(i);


    }
    public static int minimumDistance(int[] nums) {


        int min=Integer.MAX_VALUE;
        Map<Integer,List<Integer>> m= new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            m.putIfAbsent(nums[i],new ArrayList<>());
            m.get(nums[i]).add(i);

            if (m.get(nums[i]).size()>=3){

                List<Integer> list = m.get(nums[i]);

                int k= list.get(list.size()-1);

                int l=list.get(list.size()-3);


                min=Math.min(min,2*(k-l));
            }



        }

        return min==Integer.MAX_VALUE ?-1:min;
    }
}
