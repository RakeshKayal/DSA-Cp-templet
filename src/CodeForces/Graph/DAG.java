package CodeForces.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DAG {
    public static void main(String[] args) {


        int [][] edg={
                {0,4,2},
                {0,5,3},
                {5,4,1},
                {4,6,3},
                {6,1,2},
                {1,3,2},
                {4,2,1},
                {2,3,3},
        };


        class pair{
            int node;
            int wt;
            pair(int node, int wt){
                this.node=node;
                this.wt= wt;
            }
        }

        int n=7;

        int min[]= new int[n];

        for (int i = 0; i < n; i++) {
            min[i]=Integer.MAX_VALUE;
        }
        List<List<pair>> adj= new ArrayList<>();



        for (int i = 0; i <n ; i++)  adj.add(new ArrayList<>());

        for(int []it:edg){
            int u= it[0];
            int v=it[1];
            int w=it[2];
            adj.get(u).add(new pair(v,w));
        }

        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.wt-b.wt);

        pq.add(new pair(0, 0));
        min[0]=0;

        while (!pq.isEmpty()){
            pair p= pq.poll();
            int v= p.node;
            int w= p.wt;

            if (w > min[v]) continue;

            for(pair it: adj.get(v)){

                int wt=it.wt;
                int next= it.node;

                if (min[next]> w+wt){
                    min[next]=w+wt;
                }
                pq.add(new pair(next,wt+w));

            }
        }


        for (int i : min) {
            System.out.println(i);
        }


    }
}
