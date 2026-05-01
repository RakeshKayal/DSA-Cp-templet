package CodeForces.Graph;

import java.util.*;

class d5 {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d5(int n){
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

    public  int getsize(int u){
        return  size.get(u);
    }


}
public class Reverse {
    public static void main(String[] args) {

       int n = 4, p = 2,k =1 ;
        int banned[] = {0,1,3};

        int[] ints = minReverseOperations(n, p, banned, k);
        for(int it: ints){
            System.out.print(it + " ");
        }

    }
    public static int[] minReverseOperations(int n, int p, int[] banned, int k) {


        Map<Integer,Integer> m= new HashMap<>();

        d5 ob= new d5(n);

        Set<Integer> s= new TreeSet<>();
        for (int it : banned){
            s.add(it);
        }

        if (k==1){

            int ans[]= new int[n];
            ans[p]=0;

            for (int i = 0; i < n; i++) {

                if (i==p) continue;
                ans[i]=-1;

            }
            return ans;
        }
        int c=0;

        int i=p;

        while (i<n){
            if (s.contains(i)) break;
            m.put(i,c);
            i=i+k-1;
            c++;
        }

        int j=p-1;
        c=0;
        while (j>=0){

            if (s.contains(j)) break;
            m.put(j,c);
            j=j-k+1;
            c++;
        }



        for (int l = 0; l < n; l++) {

            if (s.contains(l)) continue;

            ob.unionByRanks(p,l);
        }

        int ans[]= new int[n];

        for (int l = 0; l < n; l++) {

            if (ob.findRoot(l)==ob.findRoot(p)){
                ans[l]=m.get(l)==null ? -1 :m.get(l);
            }
            else {
                ans[l]=-1;
            }
        }

        return  ans;

    }
}
