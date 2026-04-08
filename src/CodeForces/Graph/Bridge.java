package CodeForces.Graph;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static void main(String[] args) {

        int edge[][]={
                {0,1},
                {1,2},
                {2,0},
                {0,3}
        };

        int n=4;

        List<List<Integer>> adj= new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());



        for( int it[] : edge){
            int u=it[0];
            int v=it[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int visit[]= new int[n];
        int it[]= new int[n];
        int lb[]= new int[n];
        List<Integer> bridge= new ArrayList<>();

                dfsbridge(0,-1,visit,lb,it,adj,bridge);


        System.out.println(bridge);

    }

    private static void dfsbridge(int node, int parent, int[] visit, int[] lb, int[] it, List<List<Integer>> adj, List<Integer> bridge) {

        visit[node]=1;
        it[node]=lb[node]=time;
        time++;

        for(Integer neighbour: adj.get(node)){
            if (neighbour==parent) continue;

            if (visit[neighbour]!=1){

                dfsbridge(neighbour,node, visit,lb,it,adj,bridge);

                lb[node]=Math.min(lb[node],lb[neighbour]);

                if (lb[neighbour]>it[node]){

                    bridge.add(neighbour);
                    bridge.add(node);
                }

            }
            else {

                lb[node]= Math.min(lb[neighbour],lb[node]);
            }

        }
    }

    static  int time=1;
}
