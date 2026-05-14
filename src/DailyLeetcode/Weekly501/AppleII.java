package DailyLeetcode.Weekly501;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class  t{
    int v;
    int c;
    int tax;
    t(int v,int c, int tax){
        this.v=v;
        this.c=c;
        this.tax=tax;
    }
}
public class AppleII {
    public static void main(String[] args) {

        int n=3;

        int []p= {10,11,1};
        int road[][]={
                {0,2,1,3},
                {1,2,3,4},
                {0,1,5,2}
        };
        int[] ints = minCost(n, p, road);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }

    }
    public static int[] minCost(int n, int[] prices, int[][] roads) {




        List<List<t>> adj= new ArrayList<>();

        for( int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u=road[0];
            int v=road[1];
            int c=road[2];
            int t= road[3];

            adj.get(u).add(new t(v,c,t));
            adj.get(v).add(new t(u,c,t));

        }


        int ans[]= new int[n];

        for (int i = 0; i < n; i++) {

            int visit[]= new int[n];

            int i1 = dfsMin(i, adj, prices, visit);

            ans[i]=i1;
        }
        return ans;


    }

    private static int dfsMin(int node, List<List<t>> adj, int[] prices, int[] visit) {

        visit[node]=1;

        int min= prices[node];


        for( t it: adj.get(node)){

            int v=it.v;
            int c=it.c;
            int t=it.tax;
            if (visit[v]==0){
               dfsMin(v,adj,prices,visit);
                int total= c+(c*t)+prices[v];
                min= Math.min(min,total);

            }

        }
        return min;
    }
}
