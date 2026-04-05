package CodeForces.Graph;

import java.util.ArrayList;
import java.util.List;

class  ds{
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    ds(int n){
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);

        }
    }


    public  int findRoot(int u){

        if (u==parent.get(u)){
            return u;
        }
        int set= findRoot(parent.get(u));
        parent.set(u,set);
        return  parent.get(u);

    }

    public  void unionByRanks(int u, int v){

        int pv= findRoot(u);
        int pu= findRoot(v);

        if (pu==pv) return;

        if (rank.get(pu)==rank.get(pv)){

            parent.set(pv,pu);
            rank.set(pu, rank.get(pu)+1);

        }
        else if (rank.get(u)> rank.get(v)){
            parent.set(pv,pu);


        }else {
            parent.set(pu,pv);

        }



    }

    public  void  unionSize(int u, int v){
        int pu=findRoot(u);
        int pv= findRoot(v);
        if (pu==pv) return;
        if (size.get(pu)>= size.get(pv)){
            size.set(pu, size.get(pu)+size.get(pv));
            parent.set(pv,pu);

        }else {
            size.set(pv, size.get(pu)+size.get(pv));
            parent.set(pu,pv);
        }
    }


}
public class RedundentConnection {
    public static void main(String[] args) {

        int[][]edges = {
                {1,2},
                {1,3},
                {1,4},
                {3,4},
                {4,5}
        };

        int[] redundantConnection = findRedundantConnection(edges);

        for (int i = 0; i < redundantConnection.length; i++) {

            System.out.print(redundantConnection[i] + " ");
        }

    }

    public static int[] findRedundantConnection(int[][] edges) {

        List<Integer> l= new ArrayList<>();

        d d= new d(edges.length);


        for(int []it:edges){
            int u= it[0]-1;
            int v=it[1]-1;

            if (d.findRoot(u)!=d.findRoot(v)){
                d.unionByRanks(u,v);
            }else {
                l.add(u+1);
                l.add(v+1);
            }

        }

        int [] ans= new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i]=l.get(i);
        }

        return  ans;


    }
}
