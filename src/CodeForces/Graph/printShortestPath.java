package CodeForces.Graph;

import java.util.*;

public class printShortestPath {
    public static void main(String[] args) {

        int edge[][]= {
                {1,2,2},
                {1,4,1},
                {2,1,2},
                {4,1,1},
                {2,3,4},
                {2,5,5},
                {3,2,4},
                {3,5,1},
                {3,4,3},
                {4,3,3},
                {5,2,5},
                {5,3,1}
        };

        int n= 5;

        class  pair{
            int v;
            int w;
            pair(int v, int w){
                this.v=v;
                this.w=w;
            }

        }
        List<List<pair>> adj= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] it :edge){
            int u=it[0]-1;
            int v=it[1]-1;
            int w=it[2];

            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
        }


        int src=0;


        int dist[]= new  int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int cache[]= new int[n];
        Arrays.fill(cache,-1);

        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.w-b.w);

        pq.add(new pair(src,0));
        dist[src]=0;
        cache[src]=src;

        while (!pq.isEmpty()){

            pair p= pq.poll();

            int node= p.v;
            int w=p.w;

            if (dist[node]<w) continue;

            for(pair it: adj.get(node)){

                int nextNode=it.v;
                int nextWt=it.w;
                if (dist[nextNode]> nextWt+w) {
                    dist[nextNode] = nextWt + w;
                    cache[nextNode] = node;

                    pq.add(new pair(nextNode,nextWt+w));
                }

            }
        }



        int node=n-1;
        List<Integer> l= new ArrayList<>();
        l.add(node+1);

        while (cache[node]!=node){
            l.add(cache[node]+1);
            node=cache[node];
        }

        Collections.reverse(l);
        System.out.println(l);


    }
}
