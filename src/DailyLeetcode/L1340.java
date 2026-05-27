package DailyLeetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class L1340 {
    public static void main(String[] args) {


        int a[]={3,3,3,3,3};
        int d= 3;

        int i = maxJumps(a, d);
        System.out.println(i);

    }
    public static int maxJumps(int[] arr, int d) {


        int max=Integer.MIN_VALUE;
        int ele=0;

        for (int i = 0; i < arr.length; i++) {


            // for this node how much i can go

//            max= Math.max(max, findeHowMuchGo( d, arr,i));
            int t= findeHowMuchGo(d,arr,i);
            if (max<t){
                max= t;
                ele=i;
            }
        }

        return  max;




    }

    private static int findeHowMuchGo( int d, int[] arr, int idx) {

        class  pair{
            int node;
            int step;
            pair(int node, int step){
                this.node=node;
                this.step=step;
            }
        }

        Queue<pair> q= new ArrayDeque<>();
        int n= arr.length;
        //int visit[]= new int[n];
        int total=0;

        q.add(new pair(idx, 1));
       // visit[idx]=1;

        while (!q.isEmpty()) {
            pair p = q.poll();
            int nod = p.node;
            int step = p.step;
            total = Math.max(total, step);

            for (int i = 1; i <= d; i++) {
                int forward = nod + i;
                if (forward >= n || arr[forward] >= arr[nod]) break;
                q.add(new pair(forward, step + 1));
            }
            for (int i = 1; i <= d; i++) {
                int backward = nod - i;
                if (backward < 0 || arr[backward] >= arr[nod]) break;
                q.add(new pair(backward, step + 1));
            }
        }
        return  total;
    }
}
