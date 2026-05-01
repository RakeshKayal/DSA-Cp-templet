package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class d {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d(int n){
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
public class HammingDistance {
    public static void main(String[] args) {

        int s[]={1,2,3,4};
        int t[]={2,1,4,5};
        int [][]a={
                {0,1},
                {2,3}

        };
        int i = minimumHammingDistance(s, t, a);
        System.out.println(i);

    }
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {


        int n= source.length;

        d ob= new d(n);

        for ( int [] swap:allowedSwaps){

            ob.unionByRanks(swap[0],swap[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = ob.findRoot(i);
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(i);
        }

        int hammingDistance=0;

        for (List<Integer> group : groups.values()) {

            Map<Integer, Integer> sourceFreq = new HashMap<>();
            for (int idx : group) {
                sourceFreq.put(source[idx], sourceFreq.getOrDefault(source[idx], 0) + 1);
            }

            for (int idx : group) {
                int t = target[idx];
                if (sourceFreq.getOrDefault(t, 0) > 0) {
                    sourceFreq.put(t, sourceFreq.get(t) - 1);
                } else {
                    hammingDistance++;
                }
            }
        }

        

return  hammingDistance;
    }

//    private static int helper(int[] source, int[] target) {
//
//        int c=0;
//        int i=0;
//        int j=0;
//        while (i<source.length){
//            if (source[i]!=target[j])c++;
//            i++;
//            j++;
//        }
//        return  c;
//
//    }
}
