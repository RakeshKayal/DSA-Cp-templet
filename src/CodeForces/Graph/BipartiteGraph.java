package CodeForces.Graph;

import java.util.ArrayList;

public class BipartiteGraph {
    public static void main(String[] args) {


        // this is the templet
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean bpt = isBpt(4, adj);
        System.out.println(bpt);
    }

    private static boolean isBpt(int n, ArrayList<ArrayList<Integer>> adj) {



        int color[]=new int[n];

        for (int i = 0; i < n; i++) color[i]=-1;


        for (int i = 0; i < n; i++) {

            if (color[i]==-1){
                if(!dfs(i,color,0,adj))return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int[] color, int col, ArrayList<ArrayList<Integer>> adj) {


        color[i]=col;

        for(Integer it: adj.get(i)){

            if(color[it]==-1){
                if (!dfs(it, color, 1 - col, adj)) {
                    return false;
                }
            } else if (color[it]==col) {

                return false;
            }
        }
        return true;
    }
}
