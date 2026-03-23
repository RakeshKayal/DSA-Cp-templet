package Array.Intervalpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int interval[][]={

                {1,3},
                {2,6},
                {8,10},
                {15,18}

        };

        int[][] merge = merge(interval);

        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[0].length; j++) {
                System.out.print(merge[i][j]+ " ");
            }
            System.out.println();
        }

    }


    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);


        int pre= intervals[0][1];

        List<int[]> ans= new ArrayList<>();



        ans.add(new int[]{intervals[0][0],intervals[0][1]});

        for (int i = 1; i < intervals.length ; i++) {

            int start=intervals[i][0];
            int end=intervals[i][1];
            if (pre>= start) {
                //add}
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(pre, end);
                pre = last[1];

            }else{
                ans.add(new int[]{start,end});
                pre=end;
            }

    }

        return ans.toArray(new int[ans.size()][]);
    }
}
