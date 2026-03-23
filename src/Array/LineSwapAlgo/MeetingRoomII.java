package Array.LineSwapAlgo;

import java.util.*;

public class MeetingRoomII {
    public static void main(String[] args) {
        int start[] = {2, 9, 6}, end[] = {4, 12, 10};

        int slove = solve(start, end);
        System.out.println(slove);
    }

    private static int solve(int[] start, int[] end) {

        class pair{
            int node;
            int delta;
            pair(int node, int delta){
                this.node=node;
                this.delta=delta;
            }
        }


        List<pair> event= new ArrayList<>();  // event will store here


        for (int i = 0; i < start.length; i++) {

            int s=start[i];
            int e=end[i];

            event.add(new pair(s,+1));
            event.add(new pair(e,-1));
        }


        //sort the event base on small node then delta

        Collections.sort(event, Comparator
                .comparingInt((pair p) -> p.node)
                .thenComparingInt((pair p) -> p.delta));



        int sum=event.get(0).delta;

        int max=Integer.MIN_VALUE;

        for (int i = 1; i <event.size() ; i++) {

            max=Math.max(sum,max);
            sum=sum+event.get(i).delta;

        }
        return max;
    }

}
