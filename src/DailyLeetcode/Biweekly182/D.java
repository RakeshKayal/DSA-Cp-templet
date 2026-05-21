package DailyLeetcode.Biweekly182;

import java.util.*;

class  pair{
    int v;
    int w;
    pair(int v, int w){
        this.v=v;
        this.w=w;
    }
}
public class D {
    public static void main(String[] args) {

        int s=0;
        int t=4;
        int k=1;

        int n=6;
        int edge[][]={


        };
        System.out.println(minimumThreshold(n,edge,s,t,k));

    }

    public  static int minimumThreshold(int n, int[][] edges, int source, int target, int k) {


        if (edges.length==0) return 0;

        if (k==0) return 0;

        List<List<pair>> adj= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int maxW=0;
        for( int  it[]: edges){
            int u=it[0];
            int v=it[1];
            int w= it[2];

            adj.get(u).add(new pair(v,w));
            adj.get(v).add(new pair(u,w));
            maxW = Math.max(maxW, it[2]);
        }




        List<Integer> ds= dijkstraValue(adj,n,source,target);
        if (ds.isEmpty()) return -1;

        Collections.sort(ds);

        int l=0;
        int h=maxW;
        int ans=-1;

        while (l<=h){
            int mid=(l+h)/2;

            if (canPossible(mid,k,ds)){
                ans=mid;
                h=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return ans;



    }

    private static boolean canPossible(int mid, int k,List<Integer> ds) {

        int c=0;
        for (int i = ds.size()-1; i >=0 ; i--) {

            if (ds.get(i)>mid){
                c++;
            }
        }
        return c<=k;
    }

    private static List<Integer> dijkstraValue(List<List<pair>> adj, int n, int source, int target) {


        PriorityQueue<pair> q= new PriorityQueue<>((a,b)->a.w-b.w);
        int dist[]= new int[n+1];
        int cache[]= new int[n+1];
        for (int i = 0; i <=n; i++) {
            dist[i]=(int)1e9;
            cache[i]=-1;
        }
        q.add(new pair(source,0));
        dist[source]=0;

        List<Integer> ans= new ArrayList<>();

        while (!q.isEmpty()){

            pair p= q.poll();
            int u= p.v;
            int w=p.w;
            if (w>dist[u])continue;

            if (u==target) break;

            for (pair it: adj.get(u)){


                int v=it.v;
                int weight=it.w;
                int nW=w+weight;
                if (dist[v]>nW){
                    dist[v]=nW;
                    cache[v]=u;
                    q.add(new pair(v, nW));

                }

            }
        }


        if (dist[target]==(int) 1e9){
            return  new ArrayList<>();
        }

        int u = target;
        while (u != source) {
            int prev = cache[u];

            for (pair edge : adj.get(prev)) {
                if (edge.v == u) {
                    ans.add(edge.w);
                    break;
                }
            }
            u = prev;
        }
        return  ans;

    }
}
