package CodeForces.Graph;

import java.util.*;

public class noOfWay {
    public static void main(String[] args) {

        int n = 7;
        int [][]roads = {{0,6,7},
                {0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        int i = countPaths(n, roads);
        System.out.println(i);


    }
    public static int countPaths(int n, int[][] roads) {

        class pair{
            int node;
            int dist;
            pair(int node, int dits){
                this.node=node;
                this.dist=dits;
            }
        }
        int s=0;
        int d=n-1;

        List<List<pair>> adj= new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int it[]:roads){
            int u=it[0];
            int v=it[1];
            int t=it[2];

            adj.get(u).add(new pair(v,t));
            adj.get(v).add(new pair(u,t));
        }

        PriorityQueue<pair> q= new PriorityQueue<>((a,b)->a.dist-b.dist);
        q.add(new pair(s,0));

        int v []=new int[n];
        Arrays.fill(v,(int) 1e8);

        v[s]=0;
        Map<Integer,Integer> m= new TreeMap<>();

        while (!q.isEmpty()){
            pair p= q.poll();
            int node=p.node;
            int time=p.dist;

            if (time > v[node]) continue;
            if (node==d){
                m.put(time,m.getOrDefault(time,0)+1);
            }

            for(pair neighbour:adj.get(node)){

                int nextNode= neighbour.node;
                int nextTime=neighbour.dist;

                if (v[nextNode]> time+nextTime){
                    v[nextNode]=time+nextTime;
                }
                q.add(new pair(nextNode,time+nextTime));
            }
        }

        int ans=Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : m.entrySet()) {
            ans=Math.min(ans,integerIntegerEntry.getKey());

        }


        return m.get(ans);


    }
}
