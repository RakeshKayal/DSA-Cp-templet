package CodeForces.Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectioninDirectGraph {
    public static void main(String[] args) {

        int edges[][]= {
                {1,2},
                {2,3},
                {3,4},
                {4,1},

        };

        int n=4;

        List<List<Integer>> adj= new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int it[]:edges){
            int u=it[0]-1;
            int v=it[1]-1;

            adj.get(u).add(v);
        }

        boolean haveCycle = isHaveCycle(n, adj);
        System.out.println(haveCycle);

    }

    private static boolean isHaveCycle(int n, List<List<Integer>> adj) {

       int pathVis[]= new int[n];
       int vis[]= new int[n];

        for( int i=0;i<n;i++){
            if(vis[i]==0){

                if(dfsB(i,pathVis, vis, adj)) return  true;
            }
        }
        return  false;
    }

    private static boolean dfsB(int i, int[] path, int[] vis, List<List<Integer>> adj) {

        path[i]=1;
        vis[i]=1;

        for(Integer it: adj.get(i)){

            if (vis[it]!=1){

                if (dfsB(it,path,vis,adj)) return  true;
            } else if (path[it]==1) {
                return true;

            }

        }
        path[i]=0;
        return  false;
    }
}
