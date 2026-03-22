package Array.LineSwapAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MargeInterval {
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


        // templet

        class pair{
            int node;
            int delta;
            pair(int node, int delta){
                this.node=node;
                this.delta=delta;
            }
        }


        List<pair> event= new ArrayList<>();  // event will store here


        for (int[] interval : intervals) {  // having only two;

            int start=interval[0];
            int end=interval[1];

            event.add(new pair(start,+1));
            event.add(new pair(end,-1));
        }


        //sort the event base on small node then delta

        Collections.sort(event, Comparator
                .comparingInt((pair p) -> p.node)
                .thenComparingInt((pair p) -> -p.delta));



        int sum=event.get(0).delta;
        int start=event.get(0).node;


        List<int[]> ans= new ArrayList<>();


        for (int i = 1; i <event.size(); i++) {


            if(sum==0){
                ans.add(new int[]{start,event.get(i-1).node});
                start=event.get(i).node;
            }
            sum+=event.get(i).delta;
        }

        ans.add(new int[]{start, event.get(event.size() - 1).node});
        return  ans.toArray(new int[ans.size()][]);



    }
}
