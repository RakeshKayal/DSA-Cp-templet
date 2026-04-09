package CodeForces.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class d1 {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d1(int n){
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
public class SimilerStringGroup {
    public static void main(String[] args) {
        String[] strs = {"tars","rats","arts","star"};



        int n= strs.length;
        d1 ob= new d1(n);


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimiler(strs[i], strs[j])) { ob.unionByRanks(i, j); }
            }
        }

        int c=0;

        for (int j = 0; j < n; j++) {


            if (ob.findRoot(j)==j) c++;
        }
        System.out.println(c);




    }

    private static boolean isSimiler(String str, String str1) {

        int count=0;
        for (int i = 0; i <str.length() ; i++) {

            if (str.charAt(i)!=str1.charAt(i))count++;
        }
        return count == 0 || count == 2;
    }
}
