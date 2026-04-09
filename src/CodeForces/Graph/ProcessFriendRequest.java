package CodeForces.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class d2 {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d2(int n){
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
public class ProcessFriendRequest {
    public static void main(String[] args) {


        int n = 3;
        int [][]restrictions = {
                {0,1}
        };
        int [][]requests = {
                {0,2},
                {2,1}
        };

        boolean[] booleans = friendRequests(n, restrictions, requests);
        for (int i = 0; i < booleans.length; i++) {
            System.out.print(booleans[i]+",");
        }


    }
    public static boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {







        d2 ob= new d2(n);
        List<Boolean> make= new ArrayList<>();

        for(int [] it : requests){

            int u= it[0];
            int v=it[1];

            int up=ob.findRoot(u);
            int vp=ob.findRoot(v);

            Set<String> s = new HashSet<>();
            for (int[] res : restrictions) {
                int rp1 = ob.findRoot(res[0]);
                int rp2 = ob.findRoot(res[1]);
                s.add(rp1 + "_" + rp2);
                s.add(rp2 + "_" + rp1);
            }

            if (s.contains(up + "_" + vp)) {
                make.add(false);
            }else {
                ob.unionByRanks(u,v);
                make.add(true);
            }
        }

        boolean [] ans= new boolean[make.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=make.get(i);
        }
        return  ans;


    }
}
