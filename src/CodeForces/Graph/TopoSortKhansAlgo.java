package CodeForces.Graph;

import java.util.*;

public class TopoSortKhansAlgo {
    public static void main(String[] args) {


        // bfs on direct edge !


        int [][] edge= {
                {5,0},
                {4,0},
                {5,2},
                {2,3},
                {3,1},
                {4,1}
        };

        int n= 6;
        List<Integer> bfstopo = bfstopo(n, edge);
        System.out.println("bfs : "+bfstopo +" O(V+E)");

        Stack<Integer> st= new Stack<>();
        List<List<Integer>> adj= new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[]it:edge){
            int u=it[0];
            int v=it[1];

            adj.get(u).add(v);

        }
        int visit[]= new int[n];

        for(int i=0;i<n;i++){
            if(visit[i]==0){

               dfsTopo(i, visit, st, adj);
            }
        }

       List<Integer> topoDFS= new ArrayList<>();

        while (!st.isEmpty()){
            topoDFS.add(st.pop());
        }
        System.out.println("DFS : "+topoDFS +" O(V+E) +Recursion StackSpace");

    }

    private static void dfsTopo(int i, int[] visit, Stack<Integer> st, List<List<Integer>> adj) {

        visit[i]=1;
        for(Integer it: adj.get(i)){
            if(visit[it]==0){
                dfsTopo(it, visit, st, adj);
            }
        }
        st.push(i);


    }

    private static List<Integer> bfstopo(int n, int[][] edge) {
        List<List<Integer>> adj= new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());


        int indegree[]= new int[n];
        for(int[]it:edge){
            int u=it[0];
            int v=it[1];

            adj.get(u).add(v);
            indegree[v]++;
        }


        Queue<Integer> q= new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }


        List<Integer>topo= new ArrayList<>();
        while (!q.isEmpty()){
            int node= q.poll();
            topo.add(node);

            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

       // System.out.println(topo);
        return  topo;
    }
}
